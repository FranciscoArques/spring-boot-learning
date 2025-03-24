package com.learning.spring.app.models;

public class SayHelloResponse {
    private String data;

    // Constructor
    public SayHelloResponse(String data) {
        this.data = data;
    }

    // Getter and Setter
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
