package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.domain.dto.RoutesDto;
import com.flyaway.flyaway.domain.exception.DuplicateEntityException;
import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;
import com.flyaway.flyaway.domain.mapper.RouteMapper;
import com.flyaway.flyaway.entity.Country;
import com.flyaway.flyaway.entity.Route;
import com.flyaway.flyaway.repository.RoutesRepository;
import com.flyaway.flyaway.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.flyaway.flyaway.domain.mapper.RouteMapper.*;

@RequiredArgsConstructor
@Service
public class RouteServiceImp implements RouteService {

    private final RoutesRepository routesRepository;
    @Override
    public Route findById(Integer Id) {
        return routesRepository.findById(Id.longValue()).orElseThrow(()->new ResourceNotFoundException(String
                .format("Route with ID %s doesn't exist",Id)));
    }

    @Override
    public RoutesDto createRoute(RoutesDto routesDto) {
        var route = toEntity(routesDto);
        List<RoutesDto> routes = findAllRoutes();
        if (routes.stream().anyMatch(r -> r.getRouteName().equals(routesDto.getRouteName()))){
            throw new DuplicateEntityException("Route already exists");
        }else {
        routesRepository.save(route);
        return toDto(route);
        }
    }

    @Override
    public List<RoutesDto> findAllRoutes() {
        return routesRepository.findAll().stream().map(RouteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteRoute(Integer Id) {
        var routeToDelete= findById(Id);
        routesRepository.delete(routeToDelete);
    }

    @Override
    public RoutesDto addToCountry(Integer Id, Country country) {
        var route = findById(Id);
        if (route.getFromCountry()!=null &&route.getFromCountry().equals(country)){
            throw new DuplicateEntityException("From and To country cannot be the same!");
        }else {
        route.setToCountry(country);
        routesRepository.save(route);
        return toDto(route);
        }
    }
    @Override
    public RoutesDto addFromCountry(Integer Id, Country country) {
        var route = findById(Id);
        if (route.getToCountry()!=null &&route.getToCountry().equals(country)){
            throw new DuplicateEntityException("From and To country cannot be the same!");
        }else {
            route.setFromCountry(country);
            routesRepository.save(route);
            return toDto(route);
        }
    }
}
