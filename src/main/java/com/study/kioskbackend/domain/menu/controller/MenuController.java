package com.study.kioskbackend.domain.menu.controller;

import com.study.kioskbackend.domain.menu.dto.CategoryMenuResponseDto;
import com.study.kioskbackend.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/recommend")
    public List<CategoryMenuResponseDto> getRecommendMenu(@RequestParam(value = "page", defaultValue = "0") int page){
        List<CategoryMenuResponseDto> menuList = menuService.getRecommendMenu(page);
        return menuList;
    }

    @GetMapping("/menu")
    public List<CategoryMenuResponseDto> getMenu(@RequestParam Long categoryId, @RequestParam(value = "page", defaultValue = "0") int page){
        List<CategoryMenuResponseDto> menuList = menuService.getMenus(categoryId, page);
        return menuList;
    }
}
