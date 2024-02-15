package com.flyaway.flyaway.repository;

import com.flyaway.flyaway.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findAll();
}
