package com.example.kakeibo2.domain.valueobject;

import com.example.kakeibo2.domain.exception.InvalidAmountException;

import lombok.Getter;

@Getter
public class Amount {
	private final int value;
	public Amount(int value) {
		if(value <= 0) {
			throw new InvalidAmountException("金額は０より大きい必要があります");
		}
		this.value = value;
	}
	
}
