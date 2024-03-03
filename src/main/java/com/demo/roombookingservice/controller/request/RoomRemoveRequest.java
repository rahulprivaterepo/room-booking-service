package com.demo.roombookingservice.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record RoomRemoveRequest(
        @NotNull @Valid Integer roomNo
) {}
