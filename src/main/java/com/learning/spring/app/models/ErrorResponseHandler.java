package com.learning.spring.app.models;

public class ErrorResponseHandler {
    private String error;

    public ErrorResponseHandler(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
