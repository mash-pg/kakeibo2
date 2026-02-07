package com.example.kakeibo2.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.kakeibo2.domain.entity.Category;
import com.example.kakeibo2.domain.valueobject.CategoryId;

public interface CategoryRepository {
	List<Category> findAll();
	
	Optional<Category> findById(CategoryId id);

	Category save(Category category);
	
	void deleteById(CategoryId id);
}
