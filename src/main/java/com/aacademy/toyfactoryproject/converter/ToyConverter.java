package com.aacademy.toyfactoryproject.converter;

import com.aacademy.toyfactoryproject.dto.ToyDto;
import com.aacademy.toyfactoryproject.model.Order;
import com.aacademy.toyfactoryproject.model.Toy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ToyConverter {

    public ToyDto toToyDto(Toy toy) {
        return ToyDto.builder()
                .id(toy.getId())
                .name(toy.getName())
                .minAge(toy.getMinAge())
                .weightInGrams(toy.getWeightInGrams())
                .orderIds(toy.getOrders()
                        .stream()
                        .map(Order::getId)
                        .collect(Collectors.toSet()))
                .price(toy.getPrice())
                .build();
    }

    public Toy toToy(ToyDto toyDto) {
        return Toy.builder()
                .id(toyDto.getId())
                .name(toyDto.getName())
                .minAge(toyDto.getMinAge())
                .weightInGrams(toyDto.getWeightInGrams())
                .orders(toyDto.getOrderIds()
                        .stream()
                        .map((orderId) -> Order.builder().id(orderId).build())
                        .collect(Collectors.toSet()))
                .price(toyDto.getPrice())
                .build();
    }
}
