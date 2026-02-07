package com.example.kakeibo2.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo2.infrastructure.jpa.CategoryJpaEntity;

public interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity, Long>{

}
