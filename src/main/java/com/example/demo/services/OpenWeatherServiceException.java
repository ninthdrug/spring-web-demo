package com.example.demo.services;

public class OpenWeatherServiceException extends RuntimeException {

    public OpenWeatherServiceException() {
        super();
    }

    public OpenWeatherServiceException(String message) {
        super(message);
    }

    public OpenWeatherServiceException(String message, Exception e) {
        super(message, e);
    }
}
