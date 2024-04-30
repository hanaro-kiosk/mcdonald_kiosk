package com.study.kioskbackend.domain.menu.repository;

import com.study.kioskbackend.domain.menu.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
