package com.study.kioskbackend.domain.menu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryMenuResponseDto {
    private Long menuIdx;
    private String menuName;
    private String imgSrc;
    private int menuPrice;
    private int menuCalory;

    @Builder
    public CategoryMenuResponseDto(Long menuIdx, String menuName, String imgSrc, int menuPrice, int menuCalory) {
        this.menuIdx = menuIdx;
        this.menuName = menuName;
        this.imgSrc = imgSrc;
        this.menuPrice = menuPrice;
        this.menuCalory = menuCalory;
    }
}
