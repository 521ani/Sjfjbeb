package com.aacademy.toyfactoryproject.service.impl;

import com.aacademy.toyfactoryproject.exception.DuplicateRecordsException;
import com.aacademy.toyfactoryproject.exception.ResourceNotFoundException;
import com.aacademy.toyfactoryproject.model.Store;
import com.aacademy.toyfactoryproject.repository.StoreRepository;
import com.aacademy.toyfactoryproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store save(Store store) {
        try {
            return storeRepository.save(store);
        } catch (Exception exception) {
            throw new DuplicateRecordsException("Store already exists.");
        }
    }

    @Override
    public Store update(Long id, Store store) {
        Store foundStore = findById(id);
        Store updatedStore = Store.builder()
                .id(foundStore.getId())
                .name(store.getName())
                .city(store.getCity())
                .storeOwner(store.getStoreOwner())
                .orders(store.getOrders())
                .build();

        return storeRepository.save(updatedStore);
    }

    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Store wth id %d does not exist.", id)));
    }

    @Override
    public Set<Store> findAll() {
        Set<Store> stores = new TreeSet<>(Comparator.comparing(Store::getId));
        stores.addAll(storeRepository.findAll());

        return stores;
    }

    @Override
    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }
}
