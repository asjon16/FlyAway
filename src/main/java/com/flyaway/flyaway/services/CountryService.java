package com.flyaway.flyaway.services;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.Country;

import java.util.List;

public interface CountryService {

    Country findByID(Long id);

    CountryDto createNewCountry(CountryDto countryDto);
    CountryDto updateCountry(Integer id,String name);
    void deleteCountry(Integer id);
    List<CountryDto> findByName(String name);
    List<CountryDto> findAll();

}
