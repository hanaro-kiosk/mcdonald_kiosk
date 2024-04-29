package com.study.kioskbackend.domain.order.service;

import com.study.kioskbackend.domain.order.dto.OrderRequestDto;
import com.study.kioskbackend.domain.order.entity.Order;
import com.study.kioskbackend.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public ResponseEntity<Order> order(OrderRequestDto orderRequestDto) {

        try {
            int orderNum = orderRepository.findLatestOrderNumber().orElse(1)+1;
            Order order = orderRepository.save(orderRequestDto.toEntity(orderNum));
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
