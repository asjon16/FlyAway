package com.flyaway.flyaway.repository;

import com.flyaway.flyaway.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
