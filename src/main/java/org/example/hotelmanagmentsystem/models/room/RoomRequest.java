package org.example.hotelmanagmentsystem.models.room;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RoomRequest {
    private int roomNumber;
    private int capacity;
    private int pricePerNight;

}
