package com.study.kioskbackend.domain.menu.controller;

import com.study.kioskbackend.domain.menu.dto.CategoryMenuResponseDto;
import com.study.kioskbackend.domain.menu.service.MenuService;
import com.study.kioskbackend.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/recommend")
    public ResponseDto<List<CategoryMenuResponseDto>> getRecommendMenu(@RequestParam(value = "page", defaultValue = "0") int page){
        List<CategoryMenuResponseDto> menuList = menuService.getRecommendMenu(page);
        return ResponseDto.success(menuList);
    }

    @GetMapping("/menu")
    public ResponseDto<List<CategoryMenuResponseDto>> getMenu(@RequestParam Long categoryId, @RequestParam(value = "page", defaultValue = "0") int page){
        List<CategoryMenuResponseDto> menuList = menuService.getMenus(categoryId, page);
        return ResponseDto.success(menuList);
    }
}
