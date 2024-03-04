package com.demo.roombookingservice.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RoomRemoveRequest(
        @NotNull @Valid Integer roomNo
) {}
