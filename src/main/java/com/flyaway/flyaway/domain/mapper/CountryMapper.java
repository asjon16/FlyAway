package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.entity.Country;

public class CountryMapper {

    public static Country toEntity(CountryDto dto){
        Country country = new Country();
        country.setName(dto.getName());
        return country;
    }
    public static CountryDto toDto(Country country){
        CountryDto countryDto = new CountryDto();
        countryDto.setName(country.getName());
        countryDto.setId(country.getId());
        return countryDto;

    }
}
