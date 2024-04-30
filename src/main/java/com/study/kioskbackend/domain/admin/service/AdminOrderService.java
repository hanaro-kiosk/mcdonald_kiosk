package com.study.kioskbackend.domain.admin.service;


import com.study.kioskbackend.domain.admin.dto.OrderResponseDto;
import com.study.kioskbackend.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminOrderService {

    private final OrderRepository orderRepository;

    public Page<OrderResponseDto> getOrderList(int page) {
        Pageable paging = PageRequest.of(page, 5, Sort.by( Sort.Order.desc("orderTime")));
        return orderRepository.findAll(paging).map(OrderResponseDto::toDto);
    }



}
