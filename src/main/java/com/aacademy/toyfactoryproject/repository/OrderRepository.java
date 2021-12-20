package com.aacademy.toyfactoryproject.repository;

import com.aacademy.toyfactoryproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
