package com.aacademy.toyfactoryproject.service;

import com.aacademy.toyfactoryproject.model.City;

import java.util.Set;

public interface CityService {

    City save(City city);

    City update(Long id, City city);

    City findById(Long id);

    Set<City> findAll();

    void deleteById(Long id);
}
