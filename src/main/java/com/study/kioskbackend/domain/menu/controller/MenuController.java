package com.study.kioskbackend.domain.menu.controller;

import com.study.kioskbackend.domain.menu.dto.MenuListResponseDto;
import com.study.kioskbackend.domain.menu.service.MenuService;
import com.study.kioskbackend.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/recommend")
    public ResponseDto<MenuListResponseDto> getRecommendMenu(@RequestParam(value = "page", defaultValue = "0") int page){
        MenuListResponseDto menuList = menuService.getRecommendMenu(page);
        return ResponseDto.success(menuList);
    }

    @GetMapping("/menu")
    public ResponseDto<MenuListResponseDto> getMenu(@RequestParam Long categoryId, @RequestParam(value = "page", defaultValue = "0") int page){
        MenuListResponseDto menuList = menuService.getMenus(categoryId, page);
        return ResponseDto.success(menuList);
    }
}
