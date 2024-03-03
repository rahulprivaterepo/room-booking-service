package com.demo.roombookingservice.application;

import com.demo.roombookingservice.controller.request.RoomAddRequest;
import com.demo.roombookingservice.controller.request.RoomRemoveRequest;
import com.demo.roombookingservice.controller.response.RoomAddResponse;
import com.demo.roombookingservice.domain.dto.RoomType;
import com.demo.roombookingservice.domain.entity.RoomEntity;
import com.demo.roombookingservice.exception.RoomBookingPersistenceException;
import com.demo.roombookingservice.exception.RoomRemovalException;
import com.demo.roombookingservice.repository.RoomBookingRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Slf4j
public class RoomManageApplication {

    private final RoomBookingRepository roomBookingRepository;

    public RoomAddResponse addRooms(@NotNull final RoomAddRequest request) {
        final var roomEntity = buildRoomEntity(request);
        try {
            final var roomAdded = roomBookingRepository.save(roomEntity);
            return buildRoomAddResponse(roomAdded);
        } catch (Exception e) {
            log.error("Error Occurred while persisting data to DB", e);
            throw new RoomBookingPersistenceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void removeRooms(final RoomRemoveRequest roomRemoveRequest) {
        try {
            roomBookingRepository.deleteByRoomNumber(roomRemoveRequest.getRoomNo()).orElseThrow();
        } catch (Exception e) {
            log.error("Error Occurred while removing room from the DB", e);
            throw new RoomRemovalException(e.getMessage(), e);
        }
    }

    private RoomEntity buildRoomEntity(@NotNull final RoomAddRequest roomAddRequest) {
        return RoomEntity.builder()
                .roomNumber(roomAddRequest.getRoomNo())
                .roomType(roomAddRequest.getRoomType().getRoomTypeId())
                .floor(roomAddRequest.getFloor())
                .isBooked(roomAddRequest.getIsBooked())
                .build();
    }

    private RoomAddResponse buildRoomAddResponse(@NotNull final RoomEntity roomAdded) {
        return RoomAddResponse.builder()
                .id(roomAdded.getId())
                .floor(roomAdded.getFloor())
                .roomNo(roomAdded.getRoomNumber())
                .roomType(RoomType.getByRoomTypeId(roomAdded.getRoomType()))
                .build();
    }
}
