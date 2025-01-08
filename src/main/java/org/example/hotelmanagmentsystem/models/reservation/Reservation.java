package org.example.hotelmanagmentsystem.models.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.hotel.Hotel;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @UuidGenerator
    private UUID id;
    private int guestCount;
    private Date startDate;
    private Date endDate;
    @Getter
    @ManyToOne
    private Room room;
    @ManyToOne
    private Guest guest;

}
