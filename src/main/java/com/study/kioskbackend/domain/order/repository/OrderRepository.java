package com.study.kioskbackend.domain.order.repository;

import com.study.kioskbackend.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
