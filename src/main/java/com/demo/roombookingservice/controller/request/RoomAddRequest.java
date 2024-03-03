package com.demo.roombookingservice.controller.request;

import com.demo.roombookingservice.domain.dto.RoomType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomAddRequest {

    @NotNull
    @Valid
    private Integer roomNo;
    @NotNull
    @Valid
    private int floor;
    @NotNull
    @Valid
    private Boolean isBooked;
    @NotNull
    @Valid
    private RoomType roomType;
}
