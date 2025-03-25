package com.learning.spring.app.models;

public class SayHelloRequest {
    private String name;

    public SayHelloRequest() {}

    // Constructor
    public SayHelloRequest(String name) {
        this.name = name;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
