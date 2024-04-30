package com.study.kioskbackend.domain.menu.service;

import com.study.kioskbackend.domain.menu.dto.CategoryMenuResponseDto;
import com.study.kioskbackend.domain.menu.dto.MenuListResponseDto;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final ImageRepository imageRepository;

    private final int PAGE_DATA_COUNT = 9;

    @Transactional(readOnly = true)
    public MenuListResponseDto getRecommendMenu(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("menuCreateDate"));

        Pageable pageable = PageRequest.of(page, PAGE_DATA_COUNT, Sort.by(sorts));
        Page<Menu> menusEntity = menuRepository.findByMenuRecommend(pageable);

        int startPage = (((int) (Math.ceil((double) (pageable.getPageNumber() +1) / PAGE_DATA_COUNT))) -1) * PAGE_DATA_COUNT +1;
        int endPage = Math.min((startPage + PAGE_DATA_COUNT - 1), menusEntity.getTotalPages());

        List<CategoryMenuResponseDto> menus =
                menusEntity.stream().map((menu) -> CategoryMenuResponseDto.toCategoryMenuResponseDto(menu,
                                imageRepository.findById(menu.getImgIdx())
                                        .orElseThrow(() -> new IllegalArgumentException("이미지가 존재하지 않습니다"))))
                                        .collect(Collectors.toList());

        return MenuListResponseDto.builder()
                .startPage(startPage)
                .endPage(endPage)
                .list(menus)
                .build();
    }

    @Transactional(readOnly = true)
    public MenuListResponseDto getMenus(Long categoryIdx, int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("menuCreateDate"));

        Pageable pageable = PageRequest.of(page, PAGE_DATA_COUNT, Sort.by(sorts));

        Page<Menu> menusEntity = menuRepository.findByCategoryIdx(categoryIdx, pageable);
        int startPage = (((int) (Math.ceil((double) (pageable.getPageNumber() + 1) / PAGE_DATA_COUNT))) -1) * PAGE_DATA_COUNT +1;
        int endPage = Math.min((startPage + PAGE_DATA_COUNT - 1), menusEntity.getTotalPages());

        List<CategoryMenuResponseDto> menus =
                menusEntity.stream().map((menu) -> CategoryMenuResponseDto.toCategoryMenuResponseDto(menu,
                                imageRepository.findById(menu.getImgIdx())
                                    .orElseThrow(() -> new IllegalArgumentException("이미지가 존재하지 않습니다"))))
                                    .collect(Collectors.toList());

        return MenuListResponseDto.builder()
                .startPage(startPage)
                .endPage(endPage)
                .list(menus)
                .build();
    }


}
