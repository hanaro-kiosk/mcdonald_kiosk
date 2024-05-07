package com.study.kioskbackend.domain.menu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuIdx;
    @Column(nullable = false)
    private Long categoryIdx;
    @Column(nullable = false)
    private Long imgIdx;
    @Column(nullable = false)
    private String menuName;
    @Column(nullable = false)
    private int menuPrice;
    @Column(nullable = false)
    private int menuCalory;
    @Column(nullable = false, unique = true)
    private String menuCode;
    @Column(nullable = false)
    private boolean menuRecommend;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime menuCreateDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime menuUpdateDate;
    @Column(nullable = false)
    private boolean isDeleted;

    public void update(String menuName, Long categoryIdx, int menuPrice, int menuCalory, boolean menuRecommend){
        this.menuName = menuName;
        this.categoryIdx = categoryIdx;
        this.menuPrice = menuPrice;
        this.menuCalory = menuCalory;
        this.menuRecommend = menuRecommend;
        this.menuUpdateDate = LocalDateTime.now();
    }
}
