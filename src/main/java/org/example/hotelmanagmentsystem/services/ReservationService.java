package org.example.hotelmanagmentsystem.services;

import org.example.hotelmanagmentsystem.mappers.ReservationMapper;
import org.example.hotelmanagmentsystem.mappers.RoomMapper;
import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReservationService {
    ReservationMapper reservationMapper;
    RoomMapper roomMapper;
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public List<ReservationResponse> getAllReservationsPerRoom(RoomRequest room) {
        return reservationRepository.findAll()
                .stream()
                .filter(reservation -> reservation.getRoom().equals(roomMapper.toRoom(room)))
                .map(reservationMapper::toReservationResponse)
                .toList();
    }
    public void test(Room room) {
        room.getCapacity();
    }
}
