package com.learning.spring.app.controllers;
import com.learning.spring.app.models.SayHelloRequest;
import com.learning.spring.app.models.SayHelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  // This annotation makes it a REST controller
public class SayHello {
    @GetMapping("/hello")  // This will map to the '/hello' endpoint
    public SayHelloResponse sayHello() {
        return new SayHelloResponse("Hello, Spring Boot!");
    }

    @PostMapping("/hello")  // This will map to the '/hello' POST endpoint
    public SayHelloResponse sayHelloPost(@RequestBody SayHelloRequest request) {
        // Process the incoming data and return a response
        String name = request.getName();
        if (name == null || name.trim().isEmpty()) {
            name = "Joe";  // Default name if the input is null or empty
        }
        String message = "Hello, " + name.trim() + "!";
        return new SayHelloResponse(message);
    }
}
