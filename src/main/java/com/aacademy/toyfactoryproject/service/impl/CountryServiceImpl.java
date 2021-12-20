package com.aacademy.toyfactoryproject.service.impl;

import com.aacademy.toyfactoryproject.exception.DuplicateRecordsException;
import com.aacademy.toyfactoryproject.exception.ResourceNotFoundException;
import com.aacademy.toyfactoryproject.model.Country;
import com.aacademy.toyfactoryproject.repository.CountryRepository;
import com.aacademy.toyfactoryproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        try {
            return countryRepository.save(country);
        } catch (Exception exception) {
            throw new DuplicateRecordsException("Country already exists.");
        }
    }

    @Override
    public Country update(Long id, Country country) {
        Country foundCountry = findById(id);
        Country updatedCountry = Country.builder()
                .id(foundCountry.getId())
                .name(country.getName())
                .countryCode(country.getCountryCode())
                .cities(country.getCities())
                .build();

        return countryRepository.save(updatedCountry);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Country wth id %d does not exist.", id)));
    }

    @Override
    public Set<Country> findAll() {
        Set<Country> countries = new TreeSet<>(Comparator.comparing(Country::getId));
        countries.addAll(countryRepository.findAll());

        return countries;
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
