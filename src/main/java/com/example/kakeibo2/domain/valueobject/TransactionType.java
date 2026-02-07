package com.example.kakeibo2.domain.valueobject;

import com.example.kakeibo2.domain.exception.InvalidTransactionTypeException;

public enum TransactionType {
	INCOME,EXPENSE;
	
	public static TransactionType from(String value) {
		try {
			return valueOf(value.toUpperCase());
		}catch(IllegalArgumentException e) {
			throw new InvalidTransactionTypeException("不正な取引種別です : " + value);
		}
	}
}
