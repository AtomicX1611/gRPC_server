package service;

import com.grpc.HelloRequest;
import com.grpc.HelloResponse;
import com.grpc.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {
    
    @Override
    public void sayHello(HelloRequest request,StreamObserver<HelloResponse> resoponObserver){
        String name = request.getName();
        String message = "Wassuup ," + name + "!";
        String client = Context.current().toString();
        System.out.println("Received request from client: " + client+" and his name is "+name);

        HelloResponse response = HelloResponse.newBuilder()
        .setMessage(message)
        .build();

        resoponObserver.onNext(response);
        resoponObserver.onCompleted();
    }
}
