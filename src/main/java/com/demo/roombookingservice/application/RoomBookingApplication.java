package com.demo.roombookingservice.application;

import com.demo.roombookingservice.controller.request.RoomBookingRequest;
import com.demo.roombookingservice.exception.RoomsNotAvailableException;
import com.demo.roombookingservice.repository.RoomBookingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.demo.roombookingservice.constants.ExceptionConstants.ROOMS_NOT_AVAILABLE_EXCEPTION;

@AllArgsConstructor
@Service
@Slf4j
public class RoomBookingApplication {

    private RoomBookingRepository roomBookingRepository;

    public void bookRoom(
            RoomBookingRequest roomBookingRequest
    ) {
        final var roomType = roomBookingRequest.getRoomType();
        final var checkInDate = roomBookingRequest.getCheckInTime();
        final var checkOutDate = roomBookingRequest.getCheckoutTime();

        // Retrieve Available Rooms
        final var availableRooms = roomBookingRepository.
                findByRoomTypeAndIsBookedFalseAndCheckInDateAfterAndCheckOutDateBefore(
                        roomType.getRoomTypeId(),
                        checkInDate,
                        checkOutDate);

        log.info("availableRooms: {}", availableRooms);

        if (availableRooms.isEmpty()) {
            throw new RoomsNotAvailableException(ROOMS_NOT_AVAILABLE_EXCEPTION);
        }
    }
}
