package com.learning.spring.app.exceptions;

import com.learning.spring.app.models.ErrorResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle built-in ResponseStatusException
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponseHandler> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(new ErrorResponseHandler(ex.getReason()), ex.getStatusCode());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseHandler> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ErrorResponseHandler("Invalid request body: Unexpected fields found"), HttpStatus.CONFLICT);
    }
}

