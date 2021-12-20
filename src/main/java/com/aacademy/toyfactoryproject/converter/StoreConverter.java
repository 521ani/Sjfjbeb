package com.aacademy.toyfactoryproject.converter;

import com.aacademy.toyfactoryproject.dto.StoreDto;
import com.aacademy.toyfactoryproject.model.City;
import com.aacademy.toyfactoryproject.model.Order;
import com.aacademy.toyfactoryproject.model.Store;
import com.aacademy.toyfactoryproject.model.StoreOwner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StoreConverter {

    public StoreDto toStoreDto(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .cityId(store.getCity().getId())
                .storeOwnerId(store.getStoreOwner().getId())
                .orderIds(store.getOrders()
                        .stream()
                        .map(Order::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Store toStore(StoreDto storeDto) {
        return Store.builder()
                .id(storeDto.getId())
                .name(storeDto.getName())
                .storeOwner(StoreOwner.builder().id(storeDto.getStoreOwnerId()).build())
                .city(City.builder().id(storeDto.getId()).build())
                .orders(storeDto.getOrderIds()
                        .stream()
                        .map((orderId) -> Order.builder().id(orderId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
