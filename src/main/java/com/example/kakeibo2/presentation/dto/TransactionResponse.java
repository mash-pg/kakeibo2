package com.example.kakeibo2.presentation.dto;

import java.time.LocalDate;

import com.example.kakeibo2.domain.entity.Transaction;

import lombok.Getter;

@Getter
public class TransactionResponse {
	private final Long id;
	private final String type;
	private final Integer amount;
	private final Long categoryId;
	private final String description;
	private final LocalDate transactionDate;
	


	public TransactionResponse(
			Long id,
			String type,
			Integer amount,
			Long categoryId,
			String description,
			LocalDate transactionDate
			) {
		
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.categoryId = categoryId;
		this.description = description;
		this.transactionDate = transactionDate;
		
	}
	

	public static TransactionResponse fromEntity(
			Transaction transaction
			) {
	//Entity→Response
	return new TransactionResponse(
			transaction.getId().getValue(),
			transaction.getType().name(), 
			transaction.getAmount().getValue(), 
			transaction.getCategoryId().getValue(), 
			transaction.getDescription(),
			transaction.getTransactionDate()
		);
	
	}
}
