package com.example.kakeibo2.domain.valueobject;

import lombok.Getter;

@Getter
public class CategoryId {
	private final Long value;
	
	public CategoryId(Long value) {
		
		if(value == null) {
			throw new IllegalArgumentException("CategoryIdがnullです");
		}
		this.value = value;
	}
	
}
