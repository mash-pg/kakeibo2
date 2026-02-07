package com.example.kakeibo2.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo2.infrastructure.jpa.TransactionJpaEntity;

public interface TransactionJpaRepository extends JpaRepository<TransactionJpaEntity,Long>{

}
