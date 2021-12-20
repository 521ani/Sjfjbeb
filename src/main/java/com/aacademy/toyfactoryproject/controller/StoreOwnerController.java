package com.aacademy.toyfactoryproject.controller;

import com.aacademy.toyfactoryproject.converter.StoreOwnerConverter;
import com.aacademy.toyfactoryproject.dto.StoreOwnerDto;
import com.aacademy.toyfactoryproject.model.StoreOwner;
import com.aacademy.toyfactoryproject.service.StoreOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/storeowners")
public class StoreOwnerController {

    private final StoreOwnerService storeOwnerService;
    private final StoreOwnerConverter storeOwnerConverter;

    @Autowired
    public StoreOwnerController(StoreOwnerService storeOwnerService, StoreOwnerConverter storeOwnerConverter) {
        this.storeOwnerService = storeOwnerService;
        this.storeOwnerConverter = storeOwnerConverter;
    }

    @GetMapping
    public ResponseEntity<Set<StoreOwnerDto>> findAll() {
        return ResponseEntity.ok(storeOwnerService.findAll()
                .stream()
                .map(storeOwnerConverter::toStoreOwnerDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreOwnerDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(storeOwnerConverter.toStoreOwnerDto(storeOwnerService.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StoreOwnerDto> update(@PathVariable Long id, @RequestBody StoreOwner storeOwner) {
        return ResponseEntity.ok(storeOwnerConverter.toStoreOwnerDto(storeOwnerService.update(id, storeOwner)));
    }

    @PostMapping
    public ResponseEntity<StoreOwnerDto> save(@RequestBody StoreOwner storeOwner) {
        return ResponseEntity.ok(storeOwnerConverter.toStoreOwnerDto(storeOwnerService.save(storeOwner)));
    }
}
