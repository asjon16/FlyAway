package com.flyaway.flyaway.domain.controller;

import com.flyaway.flyaway.domain.dto.CountryDto;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.Country;
import com.flyaway.flyaway.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flyaway.flyaway.domain.mapper.CountryMapper.toDto;

@Controller
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<List<CountryDto>> findAll(){
        return ResponseEntity.ok((countryService.findAll()));
    }

   @GetMapping("{id}")
    public ResponseEntity<CountryDto>findById(@PathVariable Integer id){
        return ResponseEntity.ok((toDto(countryService.findByID(Long.valueOf(id)))));
    }
    @GetMapping ("/findName")
    public ResponseEntity<List<CountryDto>> findByName(@RequestParam String name){
        return ResponseEntity.ok(countryService.findByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<CountryDto>createNewCountry(@RequestBody CountryDto countryDto){
        return ResponseEntity.ok((countryService.createNewCountry(countryDto)));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CountryDto>updateCountry(@PathVariable Integer id, @RequestBody String name){
        return ResponseEntity.ok(countryService.updateCountry(id,name));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Integer id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
