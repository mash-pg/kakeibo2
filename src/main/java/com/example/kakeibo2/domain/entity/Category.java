package com.example.kakeibo2.domain.entity;

import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.CategoryName;

import lombok.Getter;

@Getter
public class Category {
	private final CategoryId id;
	private final CategoryName categoryName;
	public Category(CategoryId id,CategoryName categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}
}
