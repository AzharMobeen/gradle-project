package com.az.grpc.simple.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server Demo Start");

        Server server = ServerBuilder.forPort(50051).addService(new GreetingServiceImpl()).build();

        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Receive Shutdown Request!");
            server.shutdown();
            System.out.println("Successfully Stopped the Server!");

        }));

        server.awaitTermination();
    }
}
