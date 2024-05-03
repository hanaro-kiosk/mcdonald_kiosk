package com.study.kioskbackend.domain.admin.dto;

import com.study.kioskbackend.domain.menu.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseDto {
    private Long categoryIdx;
    private String categoryTitle;

    public CategoryResponseDto(Category category) {
        this.categoryIdx = category.getCategoryIdx();
        this.categoryTitle = category.getCategoryTitle();
    }
}
