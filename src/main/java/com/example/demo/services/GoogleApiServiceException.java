package com.example.demo.services;

public class GoogleApiServiceException extends RuntimeException {

    public GoogleApiServiceException() {
        super();
    }

    public GoogleApiServiceException(String message) {
        super(message);
    }

    public GoogleApiServiceException(String message, Exception e) {
        super(message, e);
    }
}