package com.example.kakeibo2.presentation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakeibo2.application.usecase.CategoryUseCase;
import com.example.kakeibo2.domain.entity.Category;
import com.example.kakeibo2.presentation.dto.CategoryRequest;
import com.example.kakeibo2.presentation.dto.CategoryResponse;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private final CategoryUseCase useCase;
	public CategoryController(CategoryUseCase useCase) {
		this.useCase =  useCase;
	}
	@GetMapping
	public ResponseEntity<List<CategoryResponse>> findAll(){
		List<Category> entityList =  useCase.findAll();
		//EntityのリストをResponseのリストに変換
		List<CategoryResponse>  response = entityList.stream().map(CategoryResponse::fromEntity)
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping
	public ResponseEntity<CategoryResponse> create(
			@RequestBody CategoryRequest request
			){
		Category category = useCase.create(request.getName());
		CategoryResponse response = CategoryResponse.fromEntity(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		useCase.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
