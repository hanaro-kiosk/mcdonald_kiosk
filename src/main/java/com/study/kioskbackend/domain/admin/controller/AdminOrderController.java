package com.study.kioskbackend.domain.admin.controller;

import com.study.kioskbackend.domain.admin.dto.OrderResponseDto;
import com.study.kioskbackend.domain.admin.service.AdminOrderService;
import com.study.kioskbackend.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @GetMapping("/order")
    public ResponseDto<Page<OrderResponseDto>> getOrderList(@RequestParam(value = "page",defaultValue = "0") int page) {
        return ResponseDto.success(adminOrderService.getOrderList(page));
    }

//    @PatchMapping("/order/{id}")
//    public ResponseDto<Order> editOrder(@PathVariable("id") int id, @RequestBody )

}
