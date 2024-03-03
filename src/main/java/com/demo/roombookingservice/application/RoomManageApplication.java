package com.demo.roombookingservice.application;

import com.demo.roombookingservice.controller.request.RoomAddRequest;
import com.demo.roombookingservice.controller.request.RoomRemoveRequest;
import com.demo.roombookingservice.controller.response.RoomAddResponse;
import com.demo.roombookingservice.exception.RoomAddException;
import com.demo.roombookingservice.exception.RoomRemovalException;
import com.demo.roombookingservice.repository.RoomsRepository;
import com.demo.roombookingservice.util.BuilderUtil;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Slf4j
public class RoomManageApplication {

    private final RoomsRepository roomsRepository;

    public RoomAddResponse addRooms(@NotNull final RoomAddRequest request) {
        final var roomEntity = BuilderUtil.buildRoomEntity(request);
        try {
            final var roomAdded = roomsRepository.save(roomEntity);
            return BuilderUtil.buildRoomAddResponse(roomAdded);
        } catch (Exception e) {
            log.error("Error Occurred while persisting data to DB", e);
            throw new RoomAddException(e.getMessage(), e);
        }
    }

    /*public Long modifyRooms(@NotNull final RoomModifyRequest roomModifyRequest) {
        try {
            final var roomEntity = roomsRepository.findByRoomNumber(
                    roomModifyRequest.getRoomNo()).orElseThrow(() -> new RecordNotFoundException("Record Not Found in DB")
            );
            roomEntity.setRoomType(roomModifyRequest.getRoomType().getRoomTypeId());
        } catch (Exception e) {
            log.error("Error Occurred while persisting data to DB", e);
            throw new RoomAddException(e.getMessage(), e);
        }
    }*/

    @Transactional
    public void removeRooms(final RoomRemoveRequest roomRemoveRequest) {
        try {
            roomsRepository.deleteByRoomNumber(roomRemoveRequest.roomNo()).orElseThrow();
        } catch (Exception e) {
            log.error("Error Occurred while removing room from the DB", e);
            throw new RoomRemovalException(e.getMessage(), e);
        }
    }
}
