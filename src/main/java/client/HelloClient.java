package client;

import com.grpc.HelloRequest;
import com.grpc.HelloResponse;
import com.grpc.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    public static void main(String[] args) {
            ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder()
                .setName("Karthik")
                .build();

        HelloResponse response = stub.sayHello(request);
        System.out.println("Response: " + response.getMessage());
        channel.shutdown();
    }
}
