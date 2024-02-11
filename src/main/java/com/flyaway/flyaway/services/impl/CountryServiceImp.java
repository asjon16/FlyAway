package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.domain.exception.DuplicateEntityException;
import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;
import com.flyaway.flyaway.domain.mapper.CountryMapper;
import com.flyaway.flyaway.entity.Country;
import com.flyaway.flyaway.repository.CountryRepository;
import com.flyaway.flyaway.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.flyaway.flyaway.domain.mapper.CountryMapper.toDto;
import static com.flyaway.flyaway.domain.mapper.CountryMapper.toEntity;

@RequiredArgsConstructor
@Service
public class CountryServiceImp implements CountryService {


    private final CountryRepository countryRepository;

    @Override
    public Country findByID(Long id) {
        return countryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String
                .format("Country with ID %s doesn't exist",id)));
    }

    @Override
    public CountryDto createNewCountry(CountryDto countryDto) {
        var country = toEntity(countryDto);
        List<CountryDto> countries = findAll();
        if (countries.stream().anyMatch(c -> c.getName().equals(countryDto.getName()))){
            throw new DuplicateEntityException("Country already exists");
        }else {
        countryRepository.save(country);
        return toDto(country);
        }
    }

    @Override
    public CountryDto updateCountry(Integer id,String name) {
        var countryToUpdate = findByID(id.longValue());
        countryToUpdate.setName(name);
        countryRepository.save(countryToUpdate);
        return toDto(countryToUpdate);
    }
    @Override
    public void deleteCountry(Integer id) {
        var countryToDelete = findByID(id.longValue());
        countryRepository.delete(countryToDelete);
    }

    @Override
    public List<CountryDto> findByName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name).stream().map(CountryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDto> findAll() {
        return countryRepository.findAll().stream().map(CountryMapper::toDto).collect(Collectors.toList());
    }
}
