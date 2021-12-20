package com.aacademy.toyfactoryproject.converter;

import com.aacademy.toyfactoryproject.dto.OrderDto;
import com.aacademy.toyfactoryproject.model.Order;
import com.aacademy.toyfactoryproject.model.Store;
import com.aacademy.toyfactoryproject.model.Toy;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderDto toOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .dateOrdered(order.getDateOrdered())
                .quantity(order.getQuantity())
                .storeId(order.getStore().getId())
                .toyId(order.getToy().getId())
                .build();
    }

    public Order toOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .dateOrdered(orderDto.getDateOrdered())
                .quantity(orderDto.getQuantity())
                .store(Store.builder().id(orderDto.getStoreId()).build())
                .toy(Toy.builder().id(orderDto.getToyId()).build())
                .build();
    }
}
