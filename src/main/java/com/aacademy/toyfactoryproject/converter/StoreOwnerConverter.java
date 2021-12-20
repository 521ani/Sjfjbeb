package com.aacademy.toyfactoryproject.converter;

import com.aacademy.toyfactoryproject.dto.StoreOwnerDto;
import com.aacademy.toyfactoryproject.model.City;
import com.aacademy.toyfactoryproject.model.Store;
import com.aacademy.toyfactoryproject.model.StoreOwner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StoreOwnerConverter {

    public StoreOwnerDto toStoreOwnerDto(StoreOwner storeOwner) {
        return StoreOwnerDto.builder()
                .id(storeOwner.getId())
                .name(storeOwner.getName())
                .phoneNumber(storeOwner.getPhoneNumber())
                .ucn(storeOwner.getUcn())
                .storeIds(storeOwner.getStores()
                        .stream()
                        .map(Store::getId)
                        .collect(Collectors.toSet()))
                .cityId(storeOwner.getCity().getId())
                .build();
    }

    public StoreOwner toStoreOwner(StoreOwnerDto storeOwnerDto) {
        return StoreOwner.builder()
                .id(storeOwnerDto.getId())
                .name(storeOwnerDto.getName())
                .phoneNumber(storeOwnerDto.getPhoneNumber())
                .ucn(storeOwnerDto.getUcn())
                .city(City.builder().id(storeOwnerDto.getCityId()).build())
                .stores(storeOwnerDto.getStoreIds()
                        .stream()
                        .map((storeId) -> Store.builder().id(storeId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
