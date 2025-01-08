package org.example.hotelmanagmentsystem.repositories;

import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface guestRepository extends JpaRepository<Guest, UUID> {
}
