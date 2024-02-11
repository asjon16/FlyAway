package com.flyaway.flyaway.repository;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {

    List<Country> findByNameContainingIgnoreCase(String name);
    List<Country> findAll();

}
