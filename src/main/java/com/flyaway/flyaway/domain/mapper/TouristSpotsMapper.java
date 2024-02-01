package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.TouristSpotsDto;
import com.flyaway.flyaway.entity.TouristSpots;

public class TouristSpotsMapper {

    public static TouristSpots toEntity(TouristSpotsDto dto){
        TouristSpots touristSpots = new TouristSpots();
        touristSpots.setId(dto.getId());
        touristSpots.setName(dto.getName());
        return touristSpots;
    }

    public static TouristSpotsDto toDto(TouristSpots touristSpots){
        TouristSpotsDto touristSpotsDto = new TouristSpotsDto();
        touristSpotsDto.setName(touristSpots.getName());
        touristSpotsDto.setCountry(touristSpots.getCountry().getName());
        return  touristSpotsDto;
    }
}
