package com.aacademy.toyfactoryproject.controller;

import com.aacademy.toyfactoryproject.converter.CityConverter;
import com.aacademy.toyfactoryproject.dto.CityDto;
import com.aacademy.toyfactoryproject.model.City;
import com.aacademy.toyfactoryproject.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private final CityService cityService;
    private final CityConverter cityConverter;

    @Autowired
    public CityController(CityService cityService, CityConverter cityConverter) {
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @GetMapping
    public ResponseEntity<Set<CityDto>> findAll() {
        return ResponseEntity.ok(cityService.findAll()
                .stream()
                .map(cityConverter::toCityDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cityConverter.toCityDto(cityService.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> update(@PathVariable Long id, @RequestBody City city) {
        return ResponseEntity.ok(cityConverter.toCityDto(cityService.update(id, city)));
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody City city) {
        return ResponseEntity.ok(cityConverter.toCityDto(cityService.save(city)));
    }
}
