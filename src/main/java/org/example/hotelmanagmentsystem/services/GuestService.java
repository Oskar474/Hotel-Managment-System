package org.example.hotelmanagmentsystem.services;


import lombok.RequiredArgsConstructor;
import org.example.hotelmanagmentsystem.mappers.GuestMapper;
import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.guest.GuestRequest;
import org.example.hotelmanagmentsystem.models.guest.GuestResponse;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.example.hotelmanagmentsystem.models.room.RoomRequest;
import org.example.hotelmanagmentsystem.models.room.RoomResponse;
import org.example.hotelmanagmentsystem.repositories.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestMapper guestMapper;
    private final GuestRepository guestRepository;
    public GuestResponse addGuest(GuestRequest guestRequest) {
        Guest guest = guestMapper.toGuest(guestRequest);
        return guestMapper.toGuestResponse(guestRepository.save(guest));
    }
    public GuestResponse viewGuest(String phoneNumber) {
        Optional<Guest> optionalGuest= guestRepository.findByPhoneNumber(phoneNumber);
        if (optionalGuest.isPresent())
            return guestMapper.toGuestResponse(optionalGuest.get());
        else
            return null;
    }
    public GuestResponse modifyGuest(UUID id, GuestRequest editedGuest) {
        Guest guest = guestRepository.getReferenceById(id);
        guest.setName(editedGuest.getName());
        guest.setSurname(editedGuest.getSurname());
        guest.setIdNumber(editedGuest.getIdNumber());
        guest.setPhoneNumber(editedGuest.getPhoneNumber());
        return guestMapper.toGuestResponse(guestRepository.save(guest));
    }
}