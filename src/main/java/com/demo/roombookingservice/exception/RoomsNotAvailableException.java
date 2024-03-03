package com.demo.roombookingservice.exception;

public class RoomsNotAvailableException extends RuntimeException {

    public RoomsNotAvailableException(String message) {
        super(message);
    }
}
