package com.study.kioskbackend.domain.menu.dto;

import com.study.kioskbackend.domain.menu.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryMenuResponseDto {
    private Long menuIdx;
    private String menuName;
    private String imgSrc;
    private int menuPrice;
    private int menuCalory;

    public CategoryMenuResponseDto(Menu menu, String imageUrl){
       this.menuIdx = menu.getMenuIdx();
       this.menuName = menu.getMenuName();
       this.imgSrc = imageUrl;
       this.menuPrice = menu.getMenuPrice();
       this.menuCalory = menu.getMenuCalory();
    }
}
