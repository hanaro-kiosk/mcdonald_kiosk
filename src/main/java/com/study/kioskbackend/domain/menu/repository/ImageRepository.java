package com.study.kioskbackend.domain.menu.repository;

import com.study.kioskbackend.domain.menu.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
