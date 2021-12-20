package com.aacademy.toyfactoryproject.controller;

import com.aacademy.toyfactoryproject.converter.CountryConverter;
import com.aacademy.toyfactoryproject.dto.CountryDto;
import com.aacademy.toyfactoryproject.model.Country;
import com.aacademy.toyfactoryproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    private final CountryService countryService;
    private final CountryConverter countryConverter;

    @Autowired
    public CountryController(CountryService countryService, CountryConverter countryConverter) {
        this.countryService = countryService;
        this.countryConverter = countryConverter;
    }

    @GetMapping
    public ResponseEntity<Set<CountryDto>> findAll() {
        return ResponseEntity.ok(countryService.findAll()
                .stream()
                .map(countryConverter::toCountryDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(countryConverter.toCountryDto(countryService.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CountryDto> update(@PathVariable Long id, @RequestBody Country country) {
        return ResponseEntity.ok(countryConverter.toCountryDto(countryService.update(id, country)));
    }

    @PostMapping
    public ResponseEntity<CountryDto> save(@RequestBody Country country) {
        return ResponseEntity.ok(countryConverter.toCountryDto(countryService.save(country)));
    }
}
