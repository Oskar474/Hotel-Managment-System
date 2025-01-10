package org.example.hotelmanagmentsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController

public class ReservationController {
    private final ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping("/getAllReservations")
    public ResponseEntity<List<ReservationResponse>> getAllReservationsPerRoom(@RequestBody RoomRequest room){
        return ResponseEntity.ok(service.getAllReservationsPerRoom(room));
    }
    @GetMapping("/test")
    public ResponseEntity<String> getAllReservationsPerRoom(){
        return ResponseEntity.ok("hoohoh");
    }

    @PostMapping("/addReservation")
    public ResponseEntity<String> addReservation(@RequestParam Date startDate, @RequestParam Date endDate){
        return ResponseEntity.ok("Reservation succesfull");
    }
    @DeleteMapping("/cancelReservation")
    public ResponseEntity<String> cancelReservation(@RequestParam UUID reservationId){
        return ResponseEntity.ok("Reservation canceled");
    }
}
