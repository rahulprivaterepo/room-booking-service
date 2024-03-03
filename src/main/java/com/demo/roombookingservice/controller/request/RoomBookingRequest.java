package com.demo.roombookingservice.controller.request;

import com.demo.roombookingservice.domain.dto.RoomType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomBookingRequest {

    @NotNull
    @JsonProperty("userId")
    private Long userId;
    @NotNull
    @JsonProperty("roomType")
    private RoomType roomType;
    @NotNull
    @JsonProperty("checkInTime")
    private LocalDateTime checkInTime;
    @NotNull
    @JsonProperty("checkoutTime")
    private LocalDateTime checkoutTime;
}
