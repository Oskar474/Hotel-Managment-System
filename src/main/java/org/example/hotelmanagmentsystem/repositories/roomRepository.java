package org.example.hotelmanagmentsystem.repositories;

import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface roomRepository extends JpaRepository<Room, UUID> {
}
