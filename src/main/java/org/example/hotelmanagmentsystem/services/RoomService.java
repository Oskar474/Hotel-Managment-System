package org.example.hotelmanagmentsystem.services;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.exception_handling.exceptions.RoomDoesNotExistException;
import org.example.hotelmanagmentsystem.mappers.ReservationMapper;
import org.example.hotelmanagmentsystem.mappers.RoomMapper;
import org.example.hotelmanagmentsystem.models.reservation.Reservation;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.models.room.RoomResponse;
import org.example.hotelmanagmentsystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final ReservationMapper mapper;

    public RoomResponse createRoom(RoomRequest roomRequest) {
        Room room = roomMapper.toRoom(roomRequest);
        if (roomRepository.findByRoomNumber(room.getRoomNumber()).isPresent())
            return null;
        else {
            Room savedRoom = roomRepository.save(room);
            return roomMapper.toRoomResponse(savedRoom);
        }
    }
    public Boolean deleteRoom(int roomNumber) {
        Optional<Room> optionalRoom = roomRepository.findByRoomNumber(roomNumber);
        if (optionalRoom.isPresent()) {
            roomRepository.delete(optionalRoom.get());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkIfReservationConditionsAreMet(int roomNumber, Date startDate, Date endDate) {
        Optional<Room> roomOptional = roomRepository.findByRoomNumber(roomNumber);

        if (roomOptional.isEmpty()) {
            throw new RoomDoesNotExistException("Room number: " + roomNumber + " dose not exist.");
        }

        if (startDate.after(endDate))
            return true;

        Room room = roomOptional.get();
        if (room.getReservationList().isEmpty())
            return false;

        for (Reservation reservation : room.getReservationList()) {
            Date existingStartDate = reservation.getStartDate();
            Date existingEndDate = reservation.getEndDate();
            if ((startDate.before(existingEndDate) && endDate.after(existingStartDate))) {
                return true;
            }
        }
        return false;
    }
}
