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
public class RoomModifyRequest {

    @NotNull
    @Valid
    private Integer roomNo;
    @Valid
    private Integer floor;
    @Valid
    private Boolean isBooked;
    @Valid
    private RoomType roomType;
}
