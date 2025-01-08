package org.example.hotelmanagmentsystem.models.room;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RoomResponse {
    @Id
    @UuidGenerator
    private UUID id;
    private int roomNumber;
    private int capacity;
    private boolean isOccupied;
    private int pricePerNight;
    //TODO
}
