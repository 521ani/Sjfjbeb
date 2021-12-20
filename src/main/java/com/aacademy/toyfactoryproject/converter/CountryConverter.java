package com.aacademy.toyfactoryproject.converter;

import com.aacademy.toyfactoryproject.dto.CountryDto;
import com.aacademy.toyfactoryproject.model.City;
import com.aacademy.toyfactoryproject.model.Country;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CountryConverter {

    public CountryDto toCountryDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .countryCode(country.getCountryCode())
                .cityIds(country.getCities()
                        .stream()
                        .map(City::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Country toCountry(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .countryCode(countryDto.getCountryCode())
                .cities(countryDto.getCityIds()
                        .stream()
                        .map((cityId) -> City.builder().id(cityId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
