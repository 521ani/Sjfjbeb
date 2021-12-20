package com.aacademy.toyfactoryproject.service.impl;

import com.aacademy.toyfactoryproject.exception.DuplicateRecordsException;
import com.aacademy.toyfactoryproject.exception.ResourceNotFoundException;
import com.aacademy.toyfactoryproject.model.Order;
import com.aacademy.toyfactoryproject.repository.OrderRepository;
import com.aacademy.toyfactoryproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        try {
            return orderRepository.save(order);
        } catch (Exception exception) {
            throw new DuplicateRecordsException("Order already exists.");
        }
    }

    @Override
    public Order update(Long id, Order order) {
        Order foundOrder = findById(id);
        Order updatedOrder = Order.builder()
                .id(foundOrder.getId())
                .dateOrdered(order.getDateOrdered())
                .quantity(order.getQuantity())
                .toy(order.getToy())
                .store(order.getStore())
                .build();

        return orderRepository.save(updatedOrder);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Order wth id %d does not exist.", id)));
    }

    @Override
    public Set<Order> findAll() {
        Set<Order> orders = new TreeSet<>(Comparator.comparing(Order::getId));
        orders.addAll(orderRepository.findAll());

        return orders;
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
