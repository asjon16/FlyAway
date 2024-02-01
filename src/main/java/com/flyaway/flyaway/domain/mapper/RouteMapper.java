package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.RoutesDto;
import com.flyaway.flyaway.entity.Route;

public class RouteMapper {

    public static Route toEntity(RoutesDto dto){
        Route route = new Route();
        route.setId(dto.getId());
        return route;
    }

    public static RoutesDto toDto(Route route){
        RoutesDto routesDto = new RoutesDto();
        routesDto.setToCountry(route.getToCountry().getName());
        routesDto.setFromCountry(route.getFromCountry().getName());
        return routesDto;
    }
}
