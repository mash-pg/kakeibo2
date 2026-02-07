package com.example.kakeibo2.presentation.dto;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class TransactionRequest {
	private String type;
	private Integer amount;
	private Long categoryId;
	private String description;
	private LocalDate transactionDate;
	
}
