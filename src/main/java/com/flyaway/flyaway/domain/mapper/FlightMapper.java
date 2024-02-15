package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.FlightDto;
import com.flyaway.flyaway.entity.Flight;
import com.flyaway.flyaway.entity.Reservation;
import com.flyaway.flyaway.entity.User;

import java.util.Collections;
import java.util.stream.Collectors;

public class FlightMapper {

    public static Flight toEntity(FlightDto dto){
        Flight flight = new Flight();
        flight.setId(dto.getId());
        flight.setCapacity(dto.getCapacity());
        flight.setFlightTime(dto.getFlightTime());
        return flight;
    }

    public static FlightDto toDto (Flight flight){
        FlightDto flightDto = new FlightDto();
        flightDto.setCapacity(flight.getCapacity());
        flightDto.setFlightTime(flight.getFlightTime());
        if (flight.getRoutes()!=null){
        flightDto.setRoutes(flight.getRoutes().getRouteName());
        }else {
            flightDto.setRoutes(null);
        }if (flight.getReservations()!= null){
        flightDto.setReservations(flight.getReservations().stream()
                .map(Reservation::toString).collect(Collectors.toList()));
        }else {
            flightDto.setReservations(null);
        }
        return flightDto;
    }
}
