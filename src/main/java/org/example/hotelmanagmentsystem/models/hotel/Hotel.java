package org.example.hotelmanagmentsystem.models.hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hotelmanagmentsystem.models.room.Room;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    @Id
    @UuidGenerator
    private UUID id;
    private String location;
    private String name;
    private int roomCount;
    private Date dateBuilt;
    @OneToMany
    private List<Room> rooms;
}
