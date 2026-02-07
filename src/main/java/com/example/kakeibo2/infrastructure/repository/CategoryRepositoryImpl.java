package com.example.kakeibo2.infrastructure.repository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.kakeibo2.domain.entity.Category;
import com.example.kakeibo2.domain.repository.CategoryRepository;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.infrastructure.jpa.CategoryJpaEntity;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
	private final CategoryJpaRepository jpaRepository;
	
	public CategoryRepositoryImpl(CategoryJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}
	@Override
	public Category save(Category category) {
		//Domain→JPA※データベースに保存しないといけないからVOからプリミティブに変換
		CategoryJpaEntity jpaEntity = CategoryJpaEntity.fromDomainEntity(category);
		CategoryJpaEntity saved = jpaRepository.save(jpaEntity);
		return saved.toDomainEntity();
	}
	
	@Override
	public List<Category> findAll() {
		// データベースから値を受け取るのでJPA→Domain
		List<CategoryJpaEntity> jparepository = jpaRepository.findAll();
		return jparepository.stream().map(jpa->jpa.toDomainEntity()).collect(Collectors.toList());
	}
	@Override
	public Optional<Category> findById(CategoryId categoryId) {
		
		//データベースから値を取得する。
		return jpaRepository.findById(categoryId.getValue()).map(jpa->jpa.toDomainEntity());
		
	}
	@Override
	public void deleteById(CategoryId id) {
		jpaRepository.deleteById(id.getValue());
		
	}
}
