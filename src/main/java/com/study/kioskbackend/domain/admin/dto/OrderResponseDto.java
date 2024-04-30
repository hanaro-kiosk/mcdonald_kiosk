package com.study.kioskbackend.domain.admin.dto;


import com.study.kioskbackend.domain.order.entity.Order;
import com.study.kioskbackend.domain.order.enumeration.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OrderResponseDto {

    private int idx;
    private String orderCode;
    private int orderPrice;
    private int orderNumber;
    private OrderStatus orderStatus;
    private LocalDateTime orderTime;

    public static OrderResponseDto toDto(Order order){
        return OrderResponseDto.builder()
                .idx(order.getOrderIdx().intValue())
                .orderCode(order.getOrderCode())
                .orderPrice(order.getOrderPrice())
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .orderTime(order.getOrderTime())
                .build();
    }

}
