package com.study.kioskbackend.domain.menu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuListResponseDto {
    private int startPage;
    private int endPage;
    private List<CategoryMenuResponseDto> list;

    @Builder
    public MenuListResponseDto(int startPage, int endPage, List<CategoryMenuResponseDto> list) {
        this.startPage = startPage;
        this.endPage = endPage;
        this.list = list;
    }
}
