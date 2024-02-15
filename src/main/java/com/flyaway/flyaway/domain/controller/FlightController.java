package com.flyaway.flyaway.domain.controller;


import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.domain.dto.FlightDto;
import com.flyaway.flyaway.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.flyaway.flyaway.domain.mapper.FlightMapper.toDto;

@Controller
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    //TODO TEST ALL APIs


    @GetMapping("/all")
    public ResponseEntity<List<FlightDto>> findAll(){
        return ResponseEntity.ok((flightService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<FlightDto>findById(@PathVariable Integer id){
        return ResponseEntity.ok((toDto(flightService.findById(id))));
    }
    @PostMapping("/create/{routeId}") //tested-works
    public ResponseEntity<FlightDto>createFlight(@PathVariable Integer routeId, @RequestBody Integer capacity,
                                                 @RequestParam LocalDateTime time){
        return ResponseEntity.ok(flightService.createFlight(routeId,capacity,time));
    }
    @PostMapping("/addReservation/{id}")
    public ResponseEntity<FlightDto>addReservation(@PathVariable Integer id, @RequestParam Integer reservationId){
        return ResponseEntity.ok(flightService.addReservation(id,reservationId));
    }
    @PostMapping("/removeReservation/{id}")
    public ResponseEntity<FlightDto>remove(@PathVariable Integer id, @RequestParam Integer reservationId){
        return ResponseEntity.ok(flightService.removeReservation(id,reservationId));
    }
    @PutMapping("/changeRoute/{id}")
    public ResponseEntity<FlightDto>changeRoute(@PathVariable Integer id, @RequestParam Integer routeId){
        return ResponseEntity.ok(flightService.changeFlightRoute(id,routeId));
    }
    @PutMapping("/changeTime/{id}")
    public ResponseEntity<FlightDto>changetime(@PathVariable Integer id, @RequestBody LocalDateTime time){
        return ResponseEntity.ok(flightService.updateFlightTime(id,time));
    }
    @PutMapping("/changeCapacity/{id}")
    public ResponseEntity<FlightDto>changeCapacity(@PathVariable Integer id, @RequestParam Integer capacity){
        return ResponseEntity.ok(flightService.updateCapacity(id,capacity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Integer id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
