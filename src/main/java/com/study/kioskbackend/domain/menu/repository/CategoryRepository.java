package com.study.kioskbackend.domain.menu.repository;

import com.study.kioskbackend.domain.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
