package com.demo.roombookingservice.exception;

public class RoomBookingPersistenceException extends RuntimeException {

    public RoomBookingPersistenceException(String message, Throwable e) {
        super(message, e);
    }
}
