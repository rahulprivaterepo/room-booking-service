package com.demo.roombookingservice.util;

import com.demo.roombookingservice.controller.request.RoomAddRequest;
import com.demo.roombookingservice.controller.response.RoomAddResponse;
import com.demo.roombookingservice.domain.dto.RoomType;
import com.demo.roombookingservice.domain.entity.RoomEntity;
import jakarta.validation.constraints.NotNull;

public class BuilderUtil {

    public static RoomEntity buildRoomEntity(@NotNull final RoomAddRequest roomAddRequest) {
        return RoomEntity.builder()
                .roomNumber(roomAddRequest.roomNo())
                .roomType(roomAddRequest.roomType().getRoomTypeId())
                .floor(roomAddRequest.floor())
                .isBooked(roomAddRequest.isBooked())
                .build();
    }

    public static RoomAddResponse buildRoomAddResponse(@NotNull final RoomEntity roomAdded) {
        return RoomAddResponse.builder()
                .id(roomAdded.getId())
                .floor(roomAdded.getFloor())
                .roomNo(roomAdded.getRoomNumber())
                .roomType(RoomType.getByRoomTypeId(roomAdded.getRoomType()))
                .build();
    }
}
