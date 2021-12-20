package com.aacademy.toyfactoryproject.controller;

import com.aacademy.toyfactoryproject.converter.OrderConverter;
import com.aacademy.toyfactoryproject.dto.OrderDto;
import com.aacademy.toyfactoryproject.model.Order;
import com.aacademy.toyfactoryproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @Autowired
    public OrderController(OrderService orderService, OrderConverter orderConverter) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
    }

    @GetMapping
    public ResponseEntity<Set<OrderDto>> findAll() {
        return ResponseEntity.ok(orderService.findAll()
                .stream()
                .map(orderConverter::toOrderDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderConverter.toOrderDto(orderService.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderDto> update(@PathVariable Long id, @RequestBody Order order) {
        return ResponseEntity.ok(orderConverter.toOrderDto(orderService.update(id, order)));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody Order order) {
        return ResponseEntity.ok(orderConverter.toOrderDto(orderService.save(order)));
    }
}
