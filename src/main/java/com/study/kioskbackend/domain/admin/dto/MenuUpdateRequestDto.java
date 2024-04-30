package com.study.kioskbackend.domain.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuUpdateRequestDto {
    private String menuName;
    private Long menuImgIdx;
    private int menuPrice;
    private Long menuCategory;
    private int menuCalory;
}
