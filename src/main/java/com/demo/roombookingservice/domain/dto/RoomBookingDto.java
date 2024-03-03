package com.demo.roombookingservice.domain.dto;

import com.demo.roombookingservice.domain.entity.RoomEntity;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link RoomEntity}
 */
@Value
public class RoomBookingDto implements Serializable {
    Integer roomNumber;
    Integer floor;
    Boolean isBooked;
    Long occupantId;
    RoomType roomType;
}