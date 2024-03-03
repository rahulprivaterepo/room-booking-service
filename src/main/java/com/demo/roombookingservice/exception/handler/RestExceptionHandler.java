package com.demo.roombookingservice.exception.handler;

import com.demo.roombookingservice.domain.response.ResultInfo;
import com.demo.roombookingservice.exception.RoomAddException;
import com.demo.roombookingservice.exception.RoomRemovalException;
import com.demo.roombookingservice.exception.RoomsNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.roombookingservice.constants.ErrorResultInfoConstants.ROOMS_UNAVAILABLE_ERROR;
import static com.demo.roombookingservice.constants.ErrorResultInfoConstants.ROOM_ADD_ERROR;
import static com.demo.roombookingservice.constants.ErrorResultInfoConstants.ROOM_REMOVAL_ERROR;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = RoomsNotAvailableException.class)
    public ResponseEntity<ResultInfo> handleRoomsNotAvailableException() {
        return new ResponseEntity<>(ROOMS_UNAVAILABLE_ERROR, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RoomAddException.class)
    public ResponseEntity<ResultInfo> handleRoomAddException() {
        return new ResponseEntity<>(ROOM_ADD_ERROR, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RoomRemovalException.class)
    public ResponseEntity<ResultInfo> handleRoomRemovalException() {
        return new ResponseEntity<>(ROOM_REMOVAL_ERROR, HttpStatus.BAD_REQUEST);
    }
}