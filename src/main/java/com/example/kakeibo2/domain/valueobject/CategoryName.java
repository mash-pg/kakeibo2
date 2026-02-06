package com.example.kakeibo2.domain.valueobject;

import com.example.kakeibo2.domain.exception.InvalidCategoryNameException;

import lombok.Getter;

@Getter
public class CategoryName {
	private final String value;
	
	public CategoryName(String value) {
		
		if(value == null || value.isBlank()) {
			throw new InvalidCategoryNameException("カテゴリ名が、nullまたは空文字です");
		}
		if(value.length() > 50) {
			throw new InvalidCategoryNameException("カテゴリ名が、５０文字を超えています");
		}
		this.value = value;
	}
	
}
