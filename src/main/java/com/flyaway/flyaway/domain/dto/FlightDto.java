package com.flyaway.flyaway.domain.dto;

import com.flyaway.flyaway.entity.Reservation;
import com.flyaway.flyaway.entity.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Long id;

    private Integer capacity;

    private List<String> reservations;


    private String routes;
}
