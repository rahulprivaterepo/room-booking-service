package com.demo.roombookingservice.exception;

public class RoomAddException extends RuntimeException {

    public RoomAddException(String message, Throwable e) {
        super(message, e);
    }
}
