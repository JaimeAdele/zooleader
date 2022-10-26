package edu.sjsu.cs185c.zooleader;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: grpc-zooleader.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ZooLunchGrpc {

  private ZooLunchGrpc() {}

  public static final String SERVICE_NAME = "edu.sjsu.cs185c.zooleader.ZooLunch";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest,
      edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse> getAuditMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "audit",
      requestType = edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest.class,
      responseType = edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest,
      edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse> getAuditMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest, edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse> getAuditMethod;
    if ((getAuditMethod = ZooLunchGrpc.getAuditMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getAuditMethod = ZooLunchGrpc.getAuditMethod) == null) {
          ZooLunchGrpc.getAuditMethod = getAuditMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest, edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "audit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("audit"))
              .build();
        }
      }
    }
    return getAuditMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest,
      edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse> getSkipLunchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "skipLunch",
      requestType = edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest.class,
      responseType = edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest,
      edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse> getSkipLunchMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest, edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse> getSkipLunchMethod;
    if ((getSkipLunchMethod = ZooLunchGrpc.getSkipLunchMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getSkipLunchMethod = ZooLunchGrpc.getSkipLunchMethod) == null) {
          ZooLunchGrpc.getSkipLunchMethod = getSkipLunchMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest, edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "skipLunch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("skipLunch"))
              .build();
        }
      }
    }
    return getSkipLunchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest,
      edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse> getExitZooMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "exitZoo",
      requestType = edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest.class,
      responseType = edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest,
      edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse> getExitZooMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest, edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse> getExitZooMethod;
    if ((getExitZooMethod = ZooLunchGrpc.getExitZooMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getExitZooMethod = ZooLunchGrpc.getExitZooMethod) == null) {
          ZooLunchGrpc.getExitZooMethod = getExitZooMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest, edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "exitZoo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("exitZoo"))
              .build();
        }
      }
    }
    return getExitZooMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ZooLunchStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZooLunchStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZooLunchStub>() {
        @java.lang.Override
        public ZooLunchStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZooLunchStub(channel, callOptions);
        }
      };
    return ZooLunchStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ZooLunchBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZooLunchBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZooLunchBlockingStub>() {
        @java.lang.Override
        public ZooLunchBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZooLunchBlockingStub(channel, callOptions);
        }
      };
    return ZooLunchBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ZooLunchFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZooLunchFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZooLunchFutureStub>() {
        @java.lang.Override
        public ZooLunchFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZooLunchFutureStub(channel, callOptions);
        }
      };
    return ZooLunchFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ZooLunchImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void audit(edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuditMethod(), responseObserver);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public void skipLunch(edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkipLunchMethod(), responseObserver);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public void exitZoo(edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExitZooMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuditMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest,
                edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse>(
                  this, METHODID_AUDIT)))
          .addMethod(
            getSkipLunchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest,
                edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse>(
                  this, METHODID_SKIP_LUNCH)))
          .addMethod(
            getExitZooMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest,
                edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse>(
                  this, METHODID_EXIT_ZOO)))
          .build();
    }
  }

  /**
   */
  public static final class ZooLunchStub extends io.grpc.stub.AbstractAsyncStub<ZooLunchStub> {
    private ZooLunchStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZooLunchStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZooLunchStub(channel, callOptions);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void audit(edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuditMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public void skipLunch(edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSkipLunchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public void exitZoo(edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExitZooMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ZooLunchBlockingStub extends io.grpc.stub.AbstractBlockingStub<ZooLunchBlockingStub> {
    private ZooLunchBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZooLunchBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZooLunchBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse audit(edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuditMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse skipLunch(edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSkipLunchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse exitZoo(edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExitZooMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ZooLunchFutureStub extends io.grpc.stub.AbstractFutureStub<ZooLunchFutureStub> {
    private ZooLunchFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZooLunchFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZooLunchFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse> audit(
        edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuditMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse> skipLunch(
        edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSkipLunchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse> exitZoo(
        edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExitZooMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUDIT = 0;
  private static final int METHODID_SKIP_LUNCH = 1;
  private static final int METHODID_EXIT_ZOO = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ZooLunchImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ZooLunchImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUDIT:
          serviceImpl.audit((edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.AuditResponse>) responseObserver);
          break;
        case METHODID_SKIP_LUNCH:
          serviceImpl.skipLunch((edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.SkipResponse>) responseObserver);
          break;
        case METHODID_EXIT_ZOO:
          serviceImpl.exitZoo((edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs185c.zooleader.GrpcZooleader.ExitResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ZooLunchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ZooLunchBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.sjsu.cs185c.zooleader.GrpcZooleader.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ZooLunch");
    }
  }

  private static final class ZooLunchFileDescriptorSupplier
      extends ZooLunchBaseDescriptorSupplier {
    ZooLunchFileDescriptorSupplier() {}
  }

  private static final class ZooLunchMethodDescriptorSupplier
      extends ZooLunchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ZooLunchMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ZooLunchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ZooLunchFileDescriptorSupplier())
              .addMethod(getAuditMethod())
              .addMethod(getSkipLunchMethod())
              .addMethod(getExitZooMethod())
              .build();
        }
      }
    }
    return result;
  }
}
