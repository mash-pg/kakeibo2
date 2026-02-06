package com.example.kakeibo2.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.kakeibo2.domain.valueobject.Amount;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.TransactionId;
import com.example.kakeibo2.domain.valueobject.TransactionType;

import lombok.Getter;

@Getter
public class Transaction {
	private final TransactionId id;
	private final TransactionType type;
	private final Amount amount;
	private final CategoryId categoryId;
	private final String description;
	private final LocalDate transactionDate;
	private final LocalDateTime createdAt;
	
	public Transaction(TransactionId id,
			TransactionType type, 
			Amount amount,
			CategoryId categoryId,
			String description, 
			LocalDate transactionDate, 
			LocalDateTime createdAt 
			) {
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.categoryId = categoryId;
		this.description = description;
		this.transactionDate = transactionDate;
		this.createdAt = createdAt;
		
	}
}
