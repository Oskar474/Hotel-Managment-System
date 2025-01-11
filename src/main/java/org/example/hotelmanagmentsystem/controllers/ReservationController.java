package org.example.hotelmanagmentsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.models.reservation.ReservationRequest;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservations());
    }
    @PostMapping("/addReservation")
    public ResponseEntity<String> addReservation(@RequestBody ReservationRequest reservationRequest){
        if (!reservationService.createReservation(reservationRequest)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Reservation could not be created.");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reservation created successfully.");
    }
    @DeleteMapping("/cancelReservation")
    public ResponseEntity<String> cancelReservation(@RequestBody ReservationRequest reservationRequest){
        if (reservationService.cancelReservation(reservationRequest))
            return ResponseEntity.status(HttpStatus.OK).body("Reservation canceled");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation could not be cancelled");
    }
}
