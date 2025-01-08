package org.example.hotelmanagmentsystem.services;

import org.example.hotelmanagmentsystem.mappers.ReservationMapper;
import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService {
    ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public List<ReservationResponse> getAllReservationsPerRoom(Room room) {
        return reservationRepository.findAll()
                .stream()
                //.filter(reservation -> reservation.getRoom().equals(room))
                .map(reservationMapper::toReservationResponse)
                .toList();
    }
    public void test(Room room) {
        room.getCapacity();
    }
}
