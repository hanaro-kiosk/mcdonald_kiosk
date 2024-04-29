package com.study.kioskbackend.domain.order.entity;

import com.study.kioskbackend.global.common.OrderStatus;
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
    private Long order_idx;

    private String order_code;

    private int order_price;

    private int order_count;

    private int order_number;

    @Enumerated(EnumType.STRING)
    private OrderStatus order_status;

    private LocalDateTime order_time;

    private LocalDateTime order_update_date;

    private Boolean is_deleted;

}
