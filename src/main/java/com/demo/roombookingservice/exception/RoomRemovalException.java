package com.demo.roombookingservice.exception;

public class RoomRemovalException extends RuntimeException {

    public RoomRemovalException(String message, Throwable e) {
        super(message, e);
    }
}
