package com.study.kioskbackend.domain.order.repository;

import com.study.kioskbackend.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "SELECT o.order_number FROM Order o ORDER BY o.order_number DESC")
    Optional<Integer> findLatestOrderNumber();
}
