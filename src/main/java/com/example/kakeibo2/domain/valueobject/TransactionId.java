package com.example.kakeibo2.domain.valueobject;

import lombok.Getter;

@Getter
public class TransactionId {
	private final Long value;
	
	public TransactionId(Long value) {
		
		if(value == null) {
			throw new IllegalArgumentException("TransactionIdがnullです");
		}
		this.value = value;
	}
	
}
