package com.aacademy.toyfactoryproject.service;

import com.aacademy.toyfactoryproject.model.Order;

import java.util.Set;

public interface OrderService {

    Order save(Order order);

    Order update(Long id, Order order);

    Order findById(Long id);

    Set<Order> findAll();

    void deleteById(Long id);
}
