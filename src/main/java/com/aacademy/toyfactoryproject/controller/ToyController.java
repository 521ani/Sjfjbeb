package com.aacademy.toyfactoryproject.controller;

import com.aacademy.toyfactoryproject.converter.ToyConverter;
import com.aacademy.toyfactoryproject.dto.ToyDto;
import com.aacademy.toyfactoryproject.model.Toy;
import com.aacademy.toyfactoryproject.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/toys")
public class ToyController {

    private final ToyService toyService;
    private final ToyConverter toyConverter;

    @Autowired
    public ToyController(ToyService toyService, ToyConverter toyConverter) {
        this.toyService = toyService;
        this.toyConverter = toyConverter;
    }

    @GetMapping
    public ResponseEntity<ToyDto> save(@RequestBody Toy toy) {
        return ResponseEntity.ok(toyConverter.toToyDto(toyService.save(toy)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToyDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toyConverter.toToyDto(toyService.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ToyDto> update(@PathVariable Long id, @RequestBody Toy toy) {
        return ResponseEntity.ok(toyConverter.toToyDto(toyService.update(id, toy)));
    }

    @GetMapping
    public ResponseEntity<Set<ToyDto>> findAll() {
        return ResponseEntity.ok(toyService.findAll()
                .stream()
                .map(toyConverter::toToyDto)
                .collect(Collectors.toSet()));
    }
}
