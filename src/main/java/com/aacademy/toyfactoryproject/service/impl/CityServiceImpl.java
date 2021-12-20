package com.aacademy.toyfactoryproject.service.impl;

import com.aacademy.toyfactoryproject.exception.DuplicateRecordsException;
import com.aacademy.toyfactoryproject.exception.ResourceNotFoundException;
import com.aacademy.toyfactoryproject.model.City;
import com.aacademy.toyfactoryproject.repository.CityRepository;
import com.aacademy.toyfactoryproject.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        try {
            return cityRepository.save(city);
        } catch (Exception exception) {
            throw new DuplicateRecordsException("City already exists.");
        }
    }

    @Override
    public City update(Long id, City city) {
        City foundCity = findById(id);
        City updatedCity = City.builder()
                .id(foundCity.getId())
                .name(city.getName())
                .postalCode(city.getPostalCode())
                .country(city.getCountry())
                .storeOwners(city.getStoreOwners())
                .stores(city.getStores())
                .build();

        return cityRepository.save(updatedCity);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City wth id %d does not exist.", id)));
    }

    @Override
    public Set<City> findAll() {
        Set<City> cities = new TreeSet<>(Comparator.comparing(City::getId));
        cities.addAll(cityRepository.findAll());

        return cities;
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
