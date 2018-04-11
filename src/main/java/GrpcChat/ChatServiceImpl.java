package GrpcChat;

import GrpcChat.ChatServiceGrpc.ChatServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.util.LinkedHashSet;

public class ChatServiceImpl extends ChatServiceImplBase {

    private static LinkedHashSet<StreamObserver<Chat.ChatMessageFromServer>> observers = new LinkedHashSet<>();

    public StreamObserver<Chat.ChatMessage> chat(StreamObserver<Chat.ChatMessageFromServer> responseObserver) {
        observers.add(responseObserver);

        return new StreamObserver<Chat.ChatMessage>() {
            @Override
            public void onNext(Chat.ChatMessage message) {
                // Receiving data from Client

                Chat.ChatMessageFromServer messageFromServer = Chat.ChatMessageFromServer.newBuilder()
                        .setMessage(message)
                        .build();

                observers.forEach(observers -> observers.onNext(messageFromServer));
            }

            @Override
            public void onError(Throwable t) {
                observers.remove(responseObserver);
            }

            @Override
            public void onCompleted() {
                observers.remove(responseObserver);
            }
        };
        
    }
}
