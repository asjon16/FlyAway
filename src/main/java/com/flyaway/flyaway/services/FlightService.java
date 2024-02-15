package com.flyaway.flyaway.services;

import com.flyaway.flyaway.domain.dto.FlightDto;
import com.flyaway.flyaway.entity.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    Flight findById(Integer id);
    List<FlightDto>findAll();

    FlightDto updateFlightTime(Integer flightId, LocalDateTime newTime);
    FlightDto createFlight(Integer routeId, Integer capacity, LocalDateTime time);

    FlightDto addReservation(Integer flightId,Integer reservationId);
    FlightDto removeReservation(Integer flightId,Integer reservationId);
    FlightDto updateCapacity(Integer flightId, Integer newCapacity);
    FlightDto changeFlightRoute(Integer flightId, Integer newRoute);
    void deleteFlight(Integer id);
}
