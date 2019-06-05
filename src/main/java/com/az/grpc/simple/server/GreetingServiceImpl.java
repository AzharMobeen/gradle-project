package com.az.grpc.simple.server;

import com.az.proto.greet.GreetRequest;
import com.az.proto.greet.GreetResponse;
import com.az.proto.greet.GreetServiceGrpc;
import com.az.proto.greet.Greeting;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {


    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        // Extracting the fields.
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();

        // Creating Response
        String responseString = "Hello "+firstName;
        GreetResponse greetResponse = GreetResponse.newBuilder().setResult(responseString).build();

        // Sending response
        responseObserver.onNext(greetResponse);

        responseObserver.onCompleted();
    }
}
