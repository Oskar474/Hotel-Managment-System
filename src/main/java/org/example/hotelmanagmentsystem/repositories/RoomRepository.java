package org.example.hotelmanagmentsystem.repositories;

import org.example.hotelmanagmentsystem.models.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface RoomRepository extends JpaRepository<Room, UUID> {
    Optional<Room> findByRoomNumber(int roomNumber);
}
