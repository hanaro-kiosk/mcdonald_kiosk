package com.study.kioskbackend.domain.order.dto;

import com.study.kioskbackend.domain.order.entity.Order;
import com.study.kioskbackend.domain.order.enumeration.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderRequestDto {

    private int totalCount;
    private int totalPrice;

    public Order toEntity(int orderNumber) {
        return Order.builder()
                .order_code(UUID.randomUUID().toString())
                .order_price(totalPrice)
                .order_count(totalCount)
                .order_number(orderNumber)
                .order_status(OrderStatus.결제완료)
                .order_time(LocalDateTime.now())
                .is_deleted(false)
                .build();
    }
}
