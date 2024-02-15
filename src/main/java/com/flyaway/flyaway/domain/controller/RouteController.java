package com.flyaway.flyaway.domain.controller;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.domain.dto.PasswordChanger;
import com.flyaway.flyaway.domain.dto.RoutesDto;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.Route;
import com.flyaway.flyaway.services.CountryService;
import com.flyaway.flyaway.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flyaway.flyaway.domain.mapper.RouteMapper.toDto;

@Controller
@RequestMapping("/api/route")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;
    private final CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<List<RoutesDto>> findAll(){
        return ResponseEntity.ok((routeService.findAllRoutes()));
    }

    @GetMapping("{id}")
    public ResponseEntity <RoutesDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok(toDto(routeService.findById(id)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Integer id){
        routeService.deleteRoute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<RoutesDto>createRoute(@RequestBody RoutesDto routesDto){
        return ResponseEntity.ok(routeService.createRoute(routesDto));
    }

    @PostMapping("/addToCountry/{id}")
    public ResponseEntity<RoutesDto>addToCountry(@PathVariable Integer id,@RequestParam Integer countryId){
        return ResponseEntity.ok(routeService.addToCountry(id,countryId));
    }
    @PostMapping("/addFromCountry/{id}")
    public ResponseEntity<RoutesDto>addFromCountry(@PathVariable Integer id,@RequestParam Integer countryId){
        return ResponseEntity.ok(routeService.addFromCountry(id,countryId));
    }


}
