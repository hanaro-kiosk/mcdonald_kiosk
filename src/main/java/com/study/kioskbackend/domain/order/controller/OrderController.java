package com.study.kioskbackend.domain.order.controller;

import com.study.kioskbackend.domain.order.dto.OrderRequestDto;
import com.study.kioskbackend.domain.order.entity.Order;
import com.study.kioskbackend.domain.order.service.OrderService;
import com.study.kioskbackend.domain.user.entity.User;
import com.study.kioskbackend.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseDto<Order> order(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.order(orderRequestDto);
    }

    @PatchMapping("/order")
    public ResponseDto<Void> updateUserPoint(@RequestParam("point") int point,@AuthenticationPrincipal User user) {
        return orderService.updateUserPoint(point,user.getUserId());
    }

    @GetMapping("/order")
    public ResponseDto<User> getUserPoint(@AuthenticationPrincipal User user) {
        return ResponseDto.success(orderService.getUserPoint(user.getUserId()));
    }
}
