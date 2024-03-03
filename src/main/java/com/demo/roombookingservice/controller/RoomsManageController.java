package com.demo.roombookingservice.controller;

import com.demo.roombookingservice.application.RoomManageApplication;
import com.demo.roombookingservice.controller.request.RoomAddRequest;
import com.demo.roombookingservice.controller.request.RoomRemoveRequest;
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
@RequestMapping("/v1/room-manage")
public class RoomsManageController {

    private final RoomManageApplication roomManageApplication;

    /**
     * Add a room in the Hotel
     */
    @PostMapping("addRoom")
    public ResponseEntity<String> addRoom(
            @Valid @NotNull @RequestBody RoomAddRequest roomAddRequest
    ) {
        final var roomAdded = roomManageApplication.addRooms(roomAddRequest);
        return ResponseEntityUtil.getResponseEntity(roomAdded);
    }

    @PostMapping("removeRoom")
    public ResponseEntity<String> removeRoom(
            @Valid @NotNull @RequestBody RoomRemoveRequest roomRemoveRequest
    ) {
        roomManageApplication.removeRooms(roomRemoveRequest);
        return ResponseEntityUtil.getResponseEntity(null);
    }
}
