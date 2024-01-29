package com.flyaway.flyaway.repository;

import com.flyaway.flyaway.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
