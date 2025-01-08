package org.example.hotelmanagmentsystem.repositories;

import org.example.hotelmanagmentsystem.models.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface hotelRepository extends JpaRepository<Hotel, UUID> {
}
