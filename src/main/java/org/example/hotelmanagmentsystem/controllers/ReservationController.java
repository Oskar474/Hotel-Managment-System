package org.example.hotelmanagmentsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.models.reservation.ReservationResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ReservationController {
    private final ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservationsPerRoom(@RequestBody Room room){
        return ResponseEntity.ok(service.getAllReservationsPerRoom(room));
    } //do zmiany
}
