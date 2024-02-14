package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.RoutesDto;
import com.flyaway.flyaway.entity.Route;

public class RouteMapper {

    public static Route toEntity(RoutesDto dto){
        Route route = new Route();
        route.setId(dto.getId());
        route.setRouteName(dto.getRouteName());
        return route;
    }

    public static RoutesDto toDto(Route route){
        RoutesDto routesDto = new RoutesDto();
        routesDto.setId(route.getId());
        routesDto.setRouteName(route.getRouteName());
        if (route.getToCountry() != null) {
            routesDto.setToCountry(route.getToCountry().getName());
        } else {
            routesDto.setToCountry(null);
        }
        if (route.getFromCountry() != null) {
            routesDto.setFromCountry(route.getFromCountry().getName());
        } else {
            routesDto.setFromCountry(null);
        }
        return routesDto;
    }
}
