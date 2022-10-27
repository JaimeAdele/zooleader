// i got help from hamir on this assignment. i was struggling with attempting to work with an asynchronous method or to use semaphores, but i wasn't understanding the asynchronous strategy and wasn't getting the semaphores to work. he described his "pipeline" method, where the callback for each watcher sets a watcher for the next expected thing. no code was exchanged, just descriptions of how the program ran

package edu.sjsu.cs185c.zoo;

import edu.sjsu.cs185c.zooleader.ZooLunchGrpc;
import edu.sjsu.cs185c.zooleader.GrpcZooleader;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.Stat;

public class Main {

  public static String restaurant = "SJSU Cafeteria";
  public static String leader = "No leader yet";
  public static String name;
  public static String lunch_path;
  public static ZooKeeper zk;
  public static String hostPort;
  public static long lunchZxid;
  public static long readyZxid;
  public static List<String> attendees = new ArrayList<>();
  public static boolean skip = false;
  public static int sleepTimer = 0;

  static class ZooLeaderImpl extends ZooLunchGrpc.ZooLunchImplBase {

    @Override
    public void audit(GrpcZooleader.AuditRequest request, StreamObserver<GrpcZooleader.AuditResponse> responseObserver) {
      System.out.println("-----AUDIT REQUEST RECEIVED");
      var response = GrpcZooleader.AuditResponse.newBuilder().setLunchZxid(lunchZxid).setLeader(getLeader()).addAllAttendees(attendees).build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      System.out.println("-----AUDIT REQUEST FINISHED");
    }

    @Override
    public void skipLunch(GrpcZooleader.SkipRequest request, StreamObserver<GrpcZooleader.SkipResponse> responseObserver) {
      System.out.println("-----SKIP LUNCH REQUEST RECEIVED");
      skip = true;
      var response = GrpcZooleader.SkipResponse.newBuilder().build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      System.out.println("-----SKIP LUNCH REQUEST FINISHED");
    }

    @Override 
    public void exitZoo(GrpcZooleader.ExitRequest request, StreamObserver<GrpcZooleader.ExitResponse> responseObserver) {
      System.out.println("-----EXIT REQUEST RECEIVED");
      var response = GrpcZooleader.ExitResponse.newBuilder().build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
      System.exit(0);
    }

  }

  @Command(name = "zooleader", mixinStandardHelpOptions = true, description = "go to lunch")
  static class Cli implements Callable<Integer> {
    @CommandLine.Parameters(index="0")
    String myName;

    @CommandLine.Parameters(index="1")
    String myHostPort;

    @CommandLine.Parameters(index="2")
    String zookeeper_server_list;

    @CommandLine.Parameters(index="3")
    String path;

    @Override
    public Integer call() throws Exception {
      name = myName;
      lunch_path = path;
      hostPort = myHostPort;
      int port = Integer.parseInt(hostPort.substring(hostPort.length()-4));
      var server = ServerBuilder.forPort(port).addService(new ZooLeaderImpl()).build();
      server.start();

      zk = new ZooKeeper(zookeeper_server_list, 10000, (e) -> {System.out.println(e);});

      boolean created = false;
      while (!created) {
        try {
          zk.create(lunch_path+"/employee/zk-"+name, hostPort.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
          System.out.println("-----employee node created");
          created = true;
        } catch (NodeExistsException exception) {
          Thread.sleep(1000);
        }
      }

      if (zk.exists(lunch_path+"/readyforlunch", false) == null) {
        System.out.println("-----watching for /readyforlunch creation");
        zk.exists(lunch_path+"/readyforlunch", (e) -> {watchForCreateReady(e);});
      } else {
        readyforlunchCreated();
      }



      server.awaitTermination();

      zk.close();

      return 0;
    }
  }

  // this gets passed into zk.exists() function if /readyforlunch is not expected to exist yet
  public static void watchForCreateReady(WatchedEvent e) {
    try {
      Stat stat = new Stat();
      zk.getData(lunch_path+"/readyforlunch", false, stat);
      readyZxid = stat.getCzxid();
    } catch (Exception exception) {
      exception.printStackTrace();
    }  
    // when triggered, watcher should:
      // if node indeed exists now:
      if (e.getType() == EventType.NodeCreated) {
        System.out.println("-----/readyforlunch created - expected");
        readyforlunchCreated();
      } else {
        // probably joined when readyforlunch was already going
        System.out.println("-----/readyforlunch deleted - unexpected but handled");
        try {
          // set new watcher for /readyforlunch creation
          System.out.println("-----watching for /readyforlunch creation");
          zk.exists(lunch_path+"/readyforlunch", (e2) -> {watchForCreateReady(e2);});
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
  }

  // this gets passed into zk.exists() function if /lunchtime is not expected to exist yet
  public static void watchForCreateLunchtime(WatchedEvent e) {
    // when triggered, watcher should:
      // if node indeed exists now:
      if (e.getType() == EventType.NodeCreated) {
        try {
          Stat stat = new Stat();
          zk.getData(lunch_path+"/lunchtime", false, stat);
          lunchZxid = stat.getCzxid();
        } catch (Exception exception) {
          exception.printStackTrace();
        }    
        System.out.println("-----/lunchtime created - expected");
        try {
          leader = getLeader();
          System.out.println("-----watching for /readyforlunch deletion");
          zk.exists(lunch_path+"/readyforlunch", (e2) -> {watchForDeleteReady(e2);});
          // if you are leader, create /pastlunches node
          if (leader.equals(name)) {
            setAttendees();
            String data = name+" went to "+restaurant+" with ";
            for (String attendee : attendees) {
              if (!attendee.equals("zk-"+name)) {
                data += "\n"+attendee;
              }
            }
            createPastLunchNode(data);
            sleepTimer = attendees.size() * 1000;
          }
        } catch (Exception exception) {
          exception.printStackTrace();
          System.out.println("-----PAST LUNCH NODE NOT CREATED");
        }
    } else {
      // /lunchtime was expected to be created, but it was deleted
      // probably slept too long
      System.out.println("-----/lunchtime deleted - unexpected but handled");
      
      // watch for /readyforlunch to be created
      try {
        zk.exists(lunch_path+"/readyforlunch", (e2) -> {watchForCreateReady(e2);});
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    }
  }

  // this gets passed into zk.exists() function if /readyforlunch is expected to already exist
  public static void watchForDeleteReady(WatchedEvent e) {
    if (e.getType() == EventType.NodeDeleted) {
      System.out.println("-----/readyforlunch deleted - expected");
      // delete zk node and leader node if applicable
      deleteNodes();
      // watch for /lunchtime to be deleted
      try {
        System.out.println("-----watching for /lunchtime deletion");
        zk.exists(lunch_path+"/readyforlunch", (e2) -> {watchForCreateReady(e2);});
        // zk.exists(lunch_path+"/lunchtime", (e2) -> {watchForDeleteLunchtime(e2);});
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    } else {
      System.out.println("-----/readyforlunch created - unexpected but handled");
      readyforlunchCreated();
    }
  }

  // this gets passed into zk.exists() function if /lunchtime is expected to already exist
  // public static void watchForDeleteLunchtime(WatchedEvent e) {
  //   if (e.getType() == EventType.NodeDeleted) {
  //     System.out.println("-----/lunchtime deleted - expected");
  //     // watch for /readyforlunch to be created
  //     try {
  //       System.out.println("-----watching for /readyforlunch creation");
  //       zk.exists(lunch_path+"/readyforlunch", (e2) -> {watchForCreateReady(e2);});
  //     } catch (Exception exception) {
  //       exception.printStackTrace();
  //     }
  //   } else {
  //     System.out.println("-----/LUNCHTIME CREATED - UNEXPECTED");
  //     System.out.println("-----doing nothing");
  //     // should probably handle this, but... we were guaranteed a certain order :)
  //   }
  // }

  public static void watchForDeleteLeader() {
    try {
      zk.exists(lunch_path+"/leader", (e) -> {
        if (e.getType() == EventType.NodeDeleted) {
          try {
            if (zk.exists(lunch_path+"/readyforlunch", null) != null && zk.exists(lunch_path+"/lunchtime", null) == null) {
              createLeaderNode();
            }
          } catch (Exception nestedException) {
            nestedException.printStackTrace();
          }
        }
      });
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  // this function should be called whenever /readyforlunch was created, even if it was expected to be deleted
  public static void readyforlunchCreated() {
    try {
      if (zk.exists(lunch_path+"/readyforlunch", null) != null) {
        // if you need to skip, don't create any nodes
        if (skip) {
          skip = false;
        } else {
          createZNode();
          createLeaderNode();
        }
        try {
          // create watcher for /lunchtime
          System.out.println("-----watching for /lunchtime creation");
          zk.exists(lunch_path+"/lunchtime", (e2) -> {watchForCreateLunchtime(e2);});
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    
  }

  public static void createZNode() {
    try {
      if (zk.exists(lunch_path+"/readyforlunch", null) != null) {
        try {
          zk.create(lunch_path+"/zk-"+name, hostPort.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
          System.out.println("-----zk node created: "+lunch_path+"/zk-"+name);
        } catch (Exception e) {
          System.out.println("-----ZK NODE NOT CREATED: "+lunch_path+"/zk-"+name);
        }
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  // should be called tryToCreateLeaderNode()
  public static void createLeaderNode() {
    try {
      // assumption: sleep each time you attempt to be leader, decrement timer when you fail
      System.out.println("-----sleeping for "+sleepTimer/1000+" seconds");
      Thread.sleep(sleepTimer);
      zk.create(lunch_path+"/leader", name.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
      System.out.println("-----leader node created");
    } catch (Exception e) {
      System.out.println("-----LEADER NODE NOT CREATED");
      attendees = new ArrayList<String>();
      watchForDeleteLeader();
      if (sleepTimer > 0) sleepTimer -= 1000;
    }
  }

  public static void createPastLunchNode(String data) {
    try {
      zk.create(lunch_path+"/pastlunches/lunch-", data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
      System.out.println("-----past lunch node created");
    } catch (Exception e) {
      System.out.println("-----PAST LUNCH NODE NOT CREATED");
      e.printStackTrace();
    }
  }

  public static void deleteNodes() {
    try {
      zk.delete(lunch_path+"/zk-"+name, -1);
      System.out.println("-----deleted zk node");
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    if (getLeader().equals(name)) {
      // System.out.println("-----ATTEMPTING TO DELETE LEADER NODE");
      try {
        zk.delete(lunch_path+"/leader", -1);
        System.out.println("-----deleted leader node");
      } catch (Exception exception) {
        System.out.println("-----COULDN'T DELETE LEADER NODE");
        exception.printStackTrace();
      }
    }
  }

  public static void setAttendees() {
    attendees = new ArrayList<>();
    try {
      List<String> children = zk.getChildren(lunch_path, false);
      for (String child : children) {
        Stat stat = new Stat();
        zk.getData(lunch_path+"/"+child, false, stat);
        long childZxid = stat.getCzxid();
        if (child.substring(0,3).equals("zk-") && childZxid > readyZxid && childZxid < lunchZxid) {
          attendees.add(child);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String getLeader() {
    try {
      byte[] data = zk.getData(lunch_path+"/leader", false, null);
      leader = new String(data);
    } catch (Exception e) {
      System.out.println("-----no leader currently");
    }
    return leader;
  }

  public static void main(String[] args) {
    System.exit(new CommandLine(new Cli()).execute(args));
  }
}


