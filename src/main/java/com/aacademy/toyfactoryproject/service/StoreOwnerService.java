package com.aacademy.toyfactoryproject.service;

import com.aacademy.toyfactoryproject.model.StoreOwner;

import java.util.Set;

public interface StoreOwnerService {

    StoreOwner save(StoreOwner storeOwner);

    StoreOwner update(Long id, StoreOwner storeOwner);

    StoreOwner findById(Long id);

    Set<StoreOwner> findAll();

    void deleteById(Long id);
}
