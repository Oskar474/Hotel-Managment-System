package org.example.hotelmanagmentsystem.mappers;

import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.reservation.ReservationRequest;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ReservationMapper {
    Reservation toReservation(ReservationRequest reservationRequest);
    ReservationResponse toReservationResponse(Reservation reservation);
}
