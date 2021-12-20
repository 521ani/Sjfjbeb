package com.aacademy.toyfactoryproject.service;

import com.aacademy.toyfactoryproject.model.Store;

import java.util.Set;

public interface StoreService {

    Store save(Store store);

    Store update(Long id, Store store);

    Store findById(Long id);

    Set<Store> findAll();

    void deleteById(Long id);
}
