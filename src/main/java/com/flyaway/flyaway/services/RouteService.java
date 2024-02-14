package com.flyaway.flyaway.services;

import com.flyaway.flyaway.domain.dto.RoutesDto;
import com.flyaway.flyaway.entity.Country;
import com.flyaway.flyaway.entity.Route;

import java.util.List;

public interface RouteService {

    Route findById (Integer Id);
    RoutesDto createRoute(RoutesDto routesDto);
    List<RoutesDto> findAllRoutes();
    void deleteRoute(Integer Id);
    RoutesDto addToCountry(Integer Id, Country country);
    RoutesDto addFromCountry(Integer Id, Country country);

}
