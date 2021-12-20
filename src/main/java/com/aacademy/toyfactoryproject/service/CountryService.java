package com.aacademy.toyfactoryproject.service;

import com.aacademy.toyfactoryproject.model.Country;

import java.util.Set;

public interface CountryService {

    Country save(Country country);

    Country update(Long id, Country country);

    Country findById(Long id);

    Set<Country> findAll();

    void deleteById(Long id);
}
