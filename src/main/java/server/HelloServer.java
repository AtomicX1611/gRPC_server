package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.HelloServiceImpl;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                        .addService(new HelloServiceImpl())
                        .build();
        server.start();
        System.out.println("Server started on port 50051");
        server.awaitTermination();
    }
}
