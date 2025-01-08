package org.example.hotelmanagmentsystem.mappers;

import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.guest.GuestRequest;
import org.example.hotelmanagmentsystem.models.guest.GuestResponse;
import org.mapstruct.Mapper;

@Mapper

public interface GuestMapper {
    Guest toGuest(GuestRequest guestRequest);
    GuestResponse toGuestResponse(Guest guest);
}
