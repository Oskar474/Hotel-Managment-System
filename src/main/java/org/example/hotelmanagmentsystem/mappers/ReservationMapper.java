package org.example.hotelmanagmentsystem.mappers;

import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.reservation.ReservationRequest;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(source = "guest", target = "guest")
    Reservation toReservation(ReservationRequest reservationRequest);
    @Mapping(source = "guestCount", target = "guestCount")
    @Mapping(source = "room.roomNumber", target = "roomNumber")
    ReservationResponse toReservationResponse(Reservation reservation);
}
