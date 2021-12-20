package com.aacademy.toyfactoryproject.service.impl;

import com.aacademy.toyfactoryproject.exception.DuplicateRecordsException;
import com.aacademy.toyfactoryproject.exception.ResourceNotFoundException;
import com.aacademy.toyfactoryproject.model.StoreOwner;
import com.aacademy.toyfactoryproject.repository.StoreOwnerRepository;
import com.aacademy.toyfactoryproject.service.StoreOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class StoreOwnerServiceImpl implements StoreOwnerService {

    private final StoreOwnerRepository storeOwnerRepository;

    @Autowired
    public StoreOwnerServiceImpl(StoreOwnerRepository storeOwnerRepository) {
        this.storeOwnerRepository = storeOwnerRepository;
    }

    @Override
    public StoreOwner save(StoreOwner storeOwner) {
        try {
            return storeOwnerRepository.save(storeOwner);
        } catch (Exception exception) {
            throw new DuplicateRecordsException("Store owner already exists.");
        }
    }

    @Override
    public StoreOwner update(Long id, StoreOwner storeOwner) {
        StoreOwner foundStoreOwner = findById(id);
        StoreOwner updatedStoreOwner = StoreOwner.builder()
                .id(foundStoreOwner.getId())
                .name(storeOwner.getName())
                .phoneNumber(storeOwner.getPhoneNumber())
                .ucn(storeOwner.getUcn())
                .stores(storeOwner.getStores())
                .city(storeOwner.getCity())
                .build();

        return storeOwnerRepository.save(updatedStoreOwner);
    }

    @Override
    public StoreOwner findById(Long id) {
        return storeOwnerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Store owner wth id %d does not exist.", id)));
    }

    @Override
    public Set<StoreOwner> findAll() {
        Set<StoreOwner> storeOwners = new TreeSet<>(Comparator.comparing(StoreOwner::getId));
        storeOwners.addAll(storeOwnerRepository.findAll());

        return storeOwners;
    }

    @Override
    public void deleteById(Long id) {
        storeOwnerRepository.deleteById(id);
    }
}
