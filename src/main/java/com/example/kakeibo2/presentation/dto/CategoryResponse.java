package com.example.kakeibo2.presentation.dto;



import com.example.kakeibo2.domain.entity.Category;

import lombok.Getter;

@Getter
public class CategoryResponse {
	
	private final Long id;
	private final String name;
	
	public CategoryResponse(Long id,String name) {
		this.id =id;
		this.name = name;
	}
	
	public static CategoryResponse fromEntity(
			Category category
			) {
				return new CategoryResponse(
					category.getId().getValue(),
					category.getCategoryName().getValue()
			);
	}
}
