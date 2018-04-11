package Protobuf;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(Request request, StreamObserver<Response> responseObserver) {
        System.out.println("This is the Request Object: " + request);
        responseObserver.onNext(Response.newBuilder()
                .setGreeting("Response Observer OnNext() -> GreetingServiceImpl class: " + request.getFirstname() + " " + request.getLastname())
                .build());

        responseObserver.onCompleted();
    }
}
