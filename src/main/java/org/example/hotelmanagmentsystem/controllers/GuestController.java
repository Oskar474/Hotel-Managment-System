package org.example.hotelmanagmentsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.models.guest.GuestRequest;
import org.example.hotelmanagmentsystem.models.guest.GuestResponse;
import org.example.hotelmanagmentsystem.models.room.RoomResponse;
import org.example.hotelmanagmentsystem.repositories.GuestRepository;
import org.example.hotelmanagmentsystem.services.GuestService;
import org.example.hotelmanagmentsystem.services.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;
    @PostMapping("/guest")
    public ResponseEntity<GuestResponse> addGuest(@RequestBody GuestRequest guestRequest) {
        GuestResponse guestResponse = guestService.addGuest(guestRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(guestResponse);
    }
    @GetMapping("/guest/{phoneNumber}")
    public ResponseEntity<GuestResponse> getGuest(@PathVariable String phoneNumber) {
        GuestResponse guestResponse = guestService.viewGuest(phoneNumber);

        if (guestResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(guestResponse);
    }
    @PutMapping("/guest/{id}")
    public ResponseEntity<GuestResponse> modifyGuest(@PathVariable UUID id, @RequestBody GuestRequest guestRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(guestService.modifyGuest(id,guestRequest));
    }
}

