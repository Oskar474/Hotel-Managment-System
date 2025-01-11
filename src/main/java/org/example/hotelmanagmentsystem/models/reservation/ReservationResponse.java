package org.example.hotelmanagmentsystem.models.reservation;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hotelmanagmentsystem.models.guest.GuestRequest;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReservationResponse {
    private int guestCount;
    private Date startDate;
    private Date endDate;
    private int roomNumber;

}
