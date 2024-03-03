package com.demo.roombookingservice.domain.dto;

import lombok.Getter;

@Getter
public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    EXECUTIVE(3),
    SUITE(4),
    PRESIDENTIAL_SUITE(5);

    private final int roomTypeId;

    RoomType(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public static RoomType getByRoomTypeId(final int roomTypeId) {
        for (RoomType roomType : RoomType.values()) {
            if (roomType.roomTypeId == roomTypeId) {
                return roomType;
            }
        }
        throw new IllegalArgumentException("No RoomType found with roomTypeId: " + roomTypeId);
    }
}
