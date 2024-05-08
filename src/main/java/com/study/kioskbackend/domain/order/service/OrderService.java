package com.study.kioskbackend.domain.order.service;

import com.study.kioskbackend.domain.order.dto.OrderRequestDto;
import com.study.kioskbackend.domain.order.dto.OrderResponseDto;
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
    public ResponseDto<OrderResponseDto> order(OrderRequestDto orderRequestDto, User user) {
        try {
            int orderNum = orderRepository.findLatestOrderNumber(LocalDate.now()).orElse(1) + 1;
            Order order = orderRepository.save(orderRequestDto.toEntity(orderNum));
            if(user != null) {
                User currUser = userRepository.findByUserId(user.getUserId()).orElseThrow(() -> new IllegalArgumentException("일치하는 유저가 없습니다."));
                int point = (int) (currUser.getUserPoint()+(orderRequestDto.getTotalPrice()*0.01));
                currUser.updatePoint(point);
                userRepository.save(currUser);
                return ResponseDto.success(Order.toDto(order,currUser.getUserPoint()));
            }
            return ResponseDto.success(Order.toDto(order,-1));
        } catch (Exception e) {
            return ResponseDto.fail("500", "주문목록 불러오기 실패");
        }
    }


}
