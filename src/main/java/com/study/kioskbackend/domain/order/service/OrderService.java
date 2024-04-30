package com.study.kioskbackend.domain.order.service;

import com.study.kioskbackend.domain.order.dto.OrderRequestDto;
import com.study.kioskbackend.domain.order.entity.Order;
import com.study.kioskbackend.domain.order.repository.OrderRepository;
import com.study.kioskbackend.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public ResponseDto<Order> order(OrderRequestDto orderRequestDto) {

        try {
            int orderNum = orderRepository.findLatestOrderNumber().orElse(1) + 1;
            Order order = orderRepository.save(orderRequestDto.toEntity(orderNum));
            return ResponseDto.success(order);
        } catch (Exception e) {
            return ResponseDto.fail("500", "주문목록 불러오기 실패");
        }
    }

    public ResponseDto<Integer> getUserPoint(String userId) {
        //User user = orderRepository.findByUserId(userId);
        return ResponseDto.success(1234);
    }

    public ResponseDto<Void> updateUserPoint(int point) {
        //User user = userRepository.findById(userIdx);
        //user.setUserPoint(point);
        return ResponseDto.successWithNoData();
    }


}
