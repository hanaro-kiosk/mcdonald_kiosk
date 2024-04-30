package com.study.kioskbackend.domain.menu.repository;

import com.study.kioskbackend.domain.menu.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT m FROM Menu m WHERE m.menuRecommend = TRUE")
    Page<Menu> findByMenuRecommend(Pageable pageable);
    Page<Menu> findByCategoryIdx(Long category_idx, Pageable pageable);
}
