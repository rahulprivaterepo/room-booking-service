package com.demo.roombookingservice.controller;

import com.demo.roombookingservice.application.RoomBookingApplication;
import com.demo.roombookingservice.controller.request.RoomBookingRequest;
import com.demo.roombookingservice.util.ResponseEntityUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/room-booking")
public class RoomBookingController {

    private final RoomBookingApplication roomBookingApplication;

    /**
     * Book a room in the Hotel
     */
    @PostMapping("bookRoom")
    public ResponseEntity<String> bookRoom(
            @Valid @NotNull @RequestBody RoomBookingRequest roomBookingRequest
    ) {
        log.info("Book Room Controller");
        roomBookingApplication.bookRoom(roomBookingRequest);
        return ResponseEntityUtil.getResponseEntity(null);
    }
}
