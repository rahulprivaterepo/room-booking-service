package com.demo.roombookingservice.controller.request;

import com.demo.roombookingservice.domain.dto.RoomType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RoomAddRequest(
        @NotNull @Valid Integer roomNo,
        @NotNull @Valid Integer floor,
        @NotNull @Valid Boolean isBooked,
        @NotNull @Valid RoomType roomType
) {}
