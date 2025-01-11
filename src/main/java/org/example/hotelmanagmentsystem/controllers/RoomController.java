package org.example.hotelmanagmentsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.exception_handling.exceptions.RoomDeletionException;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.models.room.RoomResponse;
import org.example.hotelmanagmentsystem.services.ReservationService;
import org.example.hotelmanagmentsystem.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final ReservationService reservationService;
    @PostMapping("/rooms")
    public ResponseEntity<RoomResponse> createRoom(@RequestBody RoomRequest roomRequest) {
        RoomResponse roomResponse = roomService.createRoom(roomRequest);
        if (roomResponse == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(roomResponse);
    }
    @DeleteMapping("/rooms/{roomNumber}")
    public ResponseEntity<String> removeRoom(@PathVariable int roomNumber) {
        if (!roomService.deleteRoom(roomNumber)) {
            throw new RoomDeletionException("Room with number " + roomNumber + " could not be deleted.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Room with number " + roomNumber + " has been deleted.");
    }
    @GetMapping("/rooms/{roomNumber}/reservations")
    public ResponseEntity<List<ReservationResponse>> getAllReservationsPerRoom(@PathVariable int roomNumber){
        return ResponseEntity.ok(reservationService.getAllReservationsPerRoom(roomNumber));
    }

}