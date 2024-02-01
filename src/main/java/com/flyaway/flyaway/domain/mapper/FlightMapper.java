package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.FlightDto;
import com.flyaway.flyaway.entity.Flight;
import com.flyaway.flyaway.entity.Reservation;

import java.util.stream.Collectors;

public class FlightMapper {

    public static Flight toEntity(FlightDto dto){
        Flight flight = new Flight();
        dto.setId(dto.getId());
        dto.setCapacity(dto.getCapacity());
        dto.setReservations(dto.getReservations());
        dto.setRoutes(dto.getRoutes());
        return flight;
    }

    public static FlightDto toDto (Flight flight){
        FlightDto flightDto = new FlightDto();
        flight.setCapacity(flight.getCapacity());
        flightDto.setRoutes(flight.getRoutes().toString());
        flightDto.setReservations(flight.getReservations().stream().map(Reservation::toString).collect(Collectors.toList()));
        return flightDto;
    }
}
