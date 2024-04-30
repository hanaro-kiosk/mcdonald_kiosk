package com.study.kioskbackend.domain.order.repository;

import com.study.kioskbackend.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "SELECT o.orderNumber FROM Order o WHERE DATE(o.orderTime) = :orderTime ORDER BY o.orderNumber DESC limit 1")
    Optional<Integer> findLatestOrderNumber(@Param("orderTime") LocalDate orderTime);
}
