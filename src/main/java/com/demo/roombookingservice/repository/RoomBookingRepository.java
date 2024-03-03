package com.demo.roombookingservice.repository;

import com.demo.roombookingservice.domain.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomEntity, Long> {
    Optional<List<RoomEntity>> findByRoomTypeAndIsBookedFalseAndCheckInDateAfterAndCheckOutDateBefore(
            Integer roomType, LocalDateTime checkInDate, LocalDateTime checkOutDate);

    Optional<Long> deleteByRoomNumber(Integer roomNumber);
}
