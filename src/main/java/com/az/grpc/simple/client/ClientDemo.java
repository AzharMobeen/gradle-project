package com.az.grpc.simple.client;

import com.az.proto.dummy.DummyServiceGrpc;
import com.az.proto.greet.GreetRequest;
import com.az.proto.greet.GreetResponse;
import com.az.proto.greet.GreetServiceGrpc;
import com.az.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientDemo {

    public static void main(String[] args) {

        System.out.println("Client Demo Start");

        // grpc need ssl for development purpose we have to use usePlaintext to avoid ssl.

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext()
                .build();
        System.out.println("Creating Stub");
        // Old dummy service.
        //DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(managedChannel);
        // For Async client
        //DummyServiceGrpc.DummyServiceFutureStub asyncClient = DummyServiceGrpc.newFutureStub(managedChannel);

        // Created a greet Service client (blocking - Synchronous)
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(managedChannel);
        // created protocol buffer greeting message.
        Greeting greeting = Greeting.newBuilder().setFirstName("Azhar").setLastName("Mobeen").build();
        // created protocol buffer greeting Request.
        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();
        // requesting and getting response.
        GreetResponse greetResponse = greetClient.greet(greetRequest);

        System.out.println("Response : "+greetResponse.getResult());

        System.out.println("Shutting down channel");
        managedChannel.shutdown();
    }
}
