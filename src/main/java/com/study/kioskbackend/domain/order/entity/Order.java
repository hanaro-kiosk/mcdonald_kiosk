package com.study.kioskbackend.domain.order.entity;

import com.study.kioskbackend.domain.admin.dto.OrderEditRequestDto;
import com.study.kioskbackend.domain.order.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "order_menu")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderIdx;

    private String orderCode;

    private int orderPrice;

    private int orderCount;

    private int orderNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime orderTime;

    private LocalDateTime orderUpdateDate;

    private Boolean isDeleted;

    public Order editOrder(Long idx, OrderEditRequestDto req) {
        return Order.builder()
                .orderIdx(idx)
                .orderPrice(req.getOrderPrice())
                .orderCount(req.getOrderCount())
                .build();
    }


}
