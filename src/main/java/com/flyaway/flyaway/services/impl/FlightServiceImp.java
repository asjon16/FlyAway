package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.domain.dto.FlightDto;
import com.flyaway.flyaway.domain.exception.AccessDeniedException;
import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;
import com.flyaway.flyaway.domain.mapper.FlightMapper;
import com.flyaway.flyaway.entity.Flight;
import com.flyaway.flyaway.repository.FlightRepository;
import com.flyaway.flyaway.services.FlightService;
import com.flyaway.flyaway.services.ReservationService;
import com.flyaway.flyaway.services.RouteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.flyaway.flyaway.domain.mapper.FlightMapper.toDto;

@Service
@RequiredArgsConstructor
public class FlightServiceImp implements FlightService {

    private final FlightRepository flightRepository;
    private final RouteService routeService;
    private final ReservationService reservationService;

    @Override
    public Flight findById(Integer id) {
      return   flightRepository.findById(id.longValue())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Flight with ID %s doesnt exist",id)));
    }

    @Override
    public List<FlightDto> findAll() {
        return flightRepository.findAll().stream().map(FlightMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public FlightDto createFlight(Integer routeId, Integer capacity, LocalDateTime time) {
        var route = routeService.findById(routeId);
        if (time.isBefore(LocalDateTime.now())){
            throw new AccessDeniedException("Time not correct");
        }
        Flight flight = new Flight();
        flight.setCapacity(capacity);
        flight.setFlightTime(time);
        flight.setRoutes(route);
        flightRepository.save(flight);
        return toDto(flight);
    }

    @Override
    public FlightDto updateFlightTime(Integer flightId, LocalDateTime newTime) {
        var flight = findById(flightId);
        if (newTime.isBefore(LocalDateTime.now())){
            throw new AccessDeniedException("Time not correct");
        }
        flight.setFlightTime(newTime);
        flightRepository.save(flight);
        return toDto(flight);
    }


    @Override
    public FlightDto addReservation(Integer flightId, Integer reservationId) {
        var flight = findById(flightId);
        var reservation = reservationService.findById(reservationId);
        flight.getReservations().add(reservation);
        return toDto(flight);
    }

    @Override
    public FlightDto removeReservation(Integer flightId, Integer reservationId) {
        var flight = findById(flightId);
        var reservation = reservationService.findById(reservationId);
        if (flight.getReservations().contains(reservation)){
            flight.getReservations().remove(reservation);
            flightRepository.save(flight);
        }else throw new ResourceNotFoundException("Reservation is not on this flight");
        return toDto(flight);
    }

    @Override
    public FlightDto updateCapacity(Integer flightId, Integer newCapacity) {
        var flight = findById(flightId);
        flight.setCapacity(newCapacity);
        flightRepository.save(flight);
        return toDto(flight);
    }

    @Override
    public FlightDto changeFlightRoute(Integer flightId, Integer newRoute) {
        var flight = findById(flightId);
        var route = routeService.findById(newRoute);
        flight.setRoutes(route);
        flightRepository.save(flight);
        return toDto(flight);
    }

    @Override
    public void deleteFlight(Integer id) {
        var flightToDelete = findById(id);
        flightRepository.delete(flightToDelete);
    }
}
