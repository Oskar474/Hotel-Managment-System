package org.example.hotelmanagmentsystem.models.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hotelmanagmentsystem.models.guest.Guest;
import org.example.hotelmanagmentsystem.models.room.Room;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int guestCount;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private Room room;
    @ManyToOne
    private Guest guest;

}
