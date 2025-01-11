package org.example.hotelmanagmentsystem.models.reservation;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.guest.GuestRequest;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {
    private int guestCount;
    private Date startDate;
    private Date endDate;
    private int roomNumber;

    @ManyToOne
    private GuestRequest guest;
}
