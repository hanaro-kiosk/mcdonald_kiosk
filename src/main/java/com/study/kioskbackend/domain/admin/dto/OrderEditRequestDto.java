package com.study.kioskbackend.domain.admin.dto;

import com.study.kioskbackend.domain.order.enumeration.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OrderEditRequestDto {

    private int orderPrice;
    private int orderCount;
}
