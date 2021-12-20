package com.aacademy.toyfactoryproject.converter;

import com.aacademy.toyfactoryproject.dto.CityDto;
import com.aacademy.toyfactoryproject.model.City;
import com.aacademy.toyfactoryproject.model.Country;
import com.aacademy.toyfactoryproject.model.Store;
import com.aacademy.toyfactoryproject.model.StoreOwner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityConverter {

    public CityDto toCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .countryId(city.getCountry().getId())
                .postalCode(city.getPostalCode())
                .storeIds(city.getStores()
                        .stream()
                        .map(Store::getId)
                        .collect(Collectors.toSet()))
                .storeOwnerIds(city.getStoreOwners()
                        .stream()
                        .map(StoreOwner::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public City toCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .postalCode(cityDto.getPostalCode())
                .country(Country.builder().id(cityDto.getCountryId()).build())
                .stores(cityDto.getStoreIds()
                        .stream()
                        .map((storeId) -> Store.builder().id(storeId).build())
                        .collect(Collectors.toSet()))
                .storeOwners(cityDto.getStoreOwnerIds()
                        .stream()
                        .map((storeOwnerId) -> StoreOwner.builder().id(storeOwnerId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
