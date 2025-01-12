package org.example.hotelmanagmentsystem.services;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.mappers.ReservationMapper;
import org.example.hotelmanagmentsystem.mappers.RoomMapper;
import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.reservation.ReservationRequest;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.repositories.GuestRepository;
import org.example.hotelmanagmentsystem.repositories.ReservationRepository;
import org.example.hotelmanagmentsystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationMapper reservationMapper;
    private final RoomMapper roomMapper;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final RoomService roomService;
    private final GuestRepository guestRepository;
    public List<ReservationResponse> getAllReservationsPerRoom(int roomNumber) {
        Optional<Room> optionalRoom = roomRepository.findByRoomNumber(roomNumber);
        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            return reservationRepository.findAll()
                    .stream()
                    .filter(reservation -> reservation.getRoom().equals(room))
                    .map(reservationMapper::toReservationResponse)
                    .toList();
        }
        return null;
    }
    public List<ReservationResponse> getAllReservations(){
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toReservationResponse)
                .toList();
    }

    public Boolean createReservation(ReservationRequest reservationRequest) {

        if (roomService.checkIfReservationConditionsAreMet(reservationRequest.getRoomNumber(), reservationRequest.getStartDate(), reservationRequest.getEndDate())) {
            return false;
        }
            else if (roomRepository.findByRoomNumber(reservationRequest.getRoomNumber()).get().getCapacity() < reservationRequest.getGuestCount()){
            return false;
        }
        else {
            Reservation reservation = reservationMapper.toReservation(reservationRequest);

            Optional<Guest> existingGuest = guestRepository.findByPhoneNumber(reservation.getGuest().getPhoneNumber());
            if (existingGuest.isPresent()) {
                reservation.setGuest(existingGuest.get());
            } else {
                guestRepository.save(reservation.getGuest());
            }
            Optional<Room> roomToSave = roomRepository.findByRoomNumber(reservationRequest.getRoomNumber());
            reservation.setRoom(roomToSave.get());

            reservationRepository.save(reservation);
            return true;
        }
    }

    public Boolean cancelReservation(ReservationRequest reservationRequest) {
        try {
            Reservation reservation = reservationRepository.findByRoom_RoomNumberAndStartDateAndEndDate(reservationRequest.getRoomNumber(),reservationRequest.getStartDate(),reservationRequest.getEndDate());
            if (reservation != null) {
                reservationRepository.deleteById(reservation.getId());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
