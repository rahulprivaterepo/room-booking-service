package com.demo.roombookingservice.controller.response;

import com.demo.roombookingservice.domain.dto.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomAddResponse {

    private Long id;
    private Integer roomNo;
    private int floor;
    private Boolean isBooked;
    private RoomType roomType;
}
