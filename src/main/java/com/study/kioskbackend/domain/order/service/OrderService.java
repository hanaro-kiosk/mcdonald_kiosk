package com.study.kioskbackend.domain.order.service;

import com.study.kioskbackend.domain.order.dto.OrderRequestDto;
import com.study.kioskbackend.domain.order.entity.Order;
import com.study.kioskbackend.domain.order.repository.OrderRepository;
import com.study.kioskbackend.domain.user.entity.User;
import com.study.kioskbackend.domain.user.repository.UserRepository;
import com.study.kioskbackend.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResponseDto<Order> order(OrderRequestDto orderRequestDto) {

        try {
            int orderNum = orderRepository.findLatestOrderNumber(LocalDate.now()).orElse(1) + 1;
            Order order = orderRepository.save(orderRequestDto.toEntity(orderNum));
            return ResponseDto.success(order);
        } catch (Exception e) {
            return ResponseDto.fail("500", "주문목록 불러오기 실패");
        }
    }

    @Transactional(readOnly = true)
    public User getUserPoint(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("일치하는 유저가 없습니다."));
    }


    @Transactional
    public ResponseDto<Void> updateUserPoint(int point,String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("일치하는 유저가 없습니다."));
        user.setUserPoint(point);
        return ResponseDto.successWithNoData();
    }


}
