package com.example.kakeibo2.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.valueobject.TransactionId;

public interface TransactionRepository {
	List<Transaction> findAll();
	Optional<Transaction> findById(TransactionId id);
	Transaction save(Transaction transaction);
	void deleteById(TransactionId id);
}
