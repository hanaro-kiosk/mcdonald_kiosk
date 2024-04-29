package com.study.kioskbackend.domain.menu.service;

import com.study.kioskbackend.domain.menu.dto.CategoryMenuResponseDto;
import com.study.kioskbackend.domain.menu.entity.Image;
import com.study.kioskbackend.domain.menu.entity.Menu;
import com.study.kioskbackend.domain.menu.repository.ImageRepository;
import com.study.kioskbackend.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public List<CategoryMenuResponseDto> getRecommendMenu(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("menuCreateDate"));

        Pageable pageable = PageRequest.of(page, 9, Sort.by(sorts));

        Page<Menu> menusEntity = menuRepository.findByMenuRecommend(pageable);

        List<CategoryMenuResponseDto> menus = new ArrayList<>();
        for(Menu menu:menusEntity){
            menus.add(toCategoryMenuResponseDto(menu));
        }
        return menus;
    }

    @Transactional(readOnly = true)
    public List<CategoryMenuResponseDto> getMenus(Long categoryIdx, int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("menuCreateDate"));

        Pageable pageable = PageRequest.of(page, 9, Sort.by(sorts));

        Page<Menu> menusEntity = menuRepository.findByCategoryIdx(categoryIdx, pageable);

        List<CategoryMenuResponseDto> menus = new ArrayList<>();
        for(Menu menu:menusEntity){
            menus.add(toCategoryMenuResponseDto(menu));
        }
        return menus;
    }

    private CategoryMenuResponseDto toCategoryMenuResponseDto(Menu menu){
        Image image = imageRepository.findById(menu.getImgIdx()).orElseThrow(
                () -> new IllegalArgumentException("이미지가 존재하지 않습니다."));

        return CategoryMenuResponseDto.builder()
                .menuIdx(menu.getMenuIdx())
                .menuName(menu.getMenuName())
                .menuPrice(menu.getMenuPrice())
                .menuCalory(menu.getMenuCalory())
                .imgSrc(image.getImgUrl())
                .build();
    }



}
