package com.example.kakeibo2.infrastructure.jpa;

import com.example.kakeibo2.domain.entity.Category;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.CategoryName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
public class CategoryJpaEntity {
	//連番設定
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	public CategoryJpaEntity() {}
	
	public CategoryJpaEntity(String name, Long id) {
		this.id = id;
		this.name = name;
	}
	
	
	//JPA Entity→Domain Entity
	public Category toDomainEntity() {
		return new Category(
				new CategoryId(this.id),
				new CategoryName(this.name)
				);
	}
	
	//Domain Entity→JPA Entity
	public static CategoryJpaEntity fromDomainEntity(Category category) {
		Long id = (category.getId() != null) ? category.getId().getValue() : null;
		String name = category.getCategoryName().getValue();
		return new CategoryJpaEntity(name, id);
	}
	
	
}
