package com.aacademy.toyfactoryproject.controller;

import com.aacademy.toyfactoryproject.converter.StoreConverter;
import com.aacademy.toyfactoryproject.dto.StoreDto;
import com.aacademy.toyfactoryproject.model.Store;
import com.aacademy.toyfactoryproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/stores")
public class StoreController {

    private final StoreService storeService;
    private final StoreConverter storeConverter;

    @Autowired
    public StoreController(StoreService storeService, StoreConverter storeConverter) {
        this.storeService = storeService;
        this.storeConverter = storeConverter;
    }

    @GetMapping
    public ResponseEntity<StoreDto> save(@RequestBody Store store) {
        return ResponseEntity.ok(storeConverter.toStoreDto(storeService.save(store)));
    }

    @GetMapping
    public ResponseEntity<Set<StoreDto>> findAll() {
        return ResponseEntity.ok(storeService.findAll()
                .stream()
                .map(storeConverter::toStoreDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(storeConverter.toStoreDto(storeService.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StoreDto> update(@PathVariable Long id, @RequestBody Store store) {
        return ResponseEntity.ok(storeConverter.toStoreDto(storeService.update(id, store)));
    }
}
