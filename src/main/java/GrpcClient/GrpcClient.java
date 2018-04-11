package GrpcClient;

import Protobuf.GreetingServiceGrpc;
import Protobuf.Request;
import Protobuf.Response;
import Protobuf.Type;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085)
                .usePlaintext(true)
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        Response response = stub.greeting(Request.newBuilder()
                .setFirstname("James")
                .setLastname("America")
                .setAge(23)
                .setType(Type.ONION)
                .putRequestResponse("Request Message", "Response/Payload")
                .build());

        System.out.println(response);

        // 1. Channel, ManagedChannel, usePlainText? Create Channel to connect to the Service built
        // 2. Load Balancing, Name resolver
        // 3. Blocking vs Non-Blocking stubs
        // 4. Futures
        // 5. Builders

    }
}
