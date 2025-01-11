package org.example.hotelmanagmentsystem.models.guest;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class GuestRequest {
    private String name;
    private String surname;
    private String phoneNumber;
    private String idNumber;
}
