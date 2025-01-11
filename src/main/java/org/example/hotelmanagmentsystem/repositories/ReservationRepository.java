package org.example.hotelmanagmentsystem.repositories;

import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    Reservation findByRoom_RoomNumberAndStartDateAndEndDate(int roomNumber, Date startDate, Date endDate);
}
