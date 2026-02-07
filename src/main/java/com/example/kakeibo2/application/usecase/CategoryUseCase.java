package com.example.kakeibo2.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakeibo2.domain.entity.Category;
import com.example.kakeibo2.domain.exception.CategoryNotFoundException;
import com.example.kakeibo2.domain.repository.CategoryRepository;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.CategoryName;


@Service
public class CategoryUseCase {
	//DIで必要なRepositoryを取得する
	private final CategoryRepository categoryRepository;
	//コンストラクタインジェクション作成
	public CategoryUseCase(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	//1.カテゴリ一覧取得
	public List<Category> findAll(){
		return categoryRepository.findAll();
		
	}
	//2.カテゴリ登録（名前を受け取ってCategoryを返す）
	@Transactional
	public Category create(String name) {
		//レポジトリからどの値を登録するかを見つける
		CategoryName categoryName = new CategoryName(name);
		Category category = new Category(null, categoryName);
		return categoryRepository.save(category);

	}
	
	//3.カテゴリ削除（IDを受け取る）	
	@Transactional
	public void delete(Long id) {
		CategoryId categoryId = new CategoryId(id);
		categoryRepository.findById(categoryId)
			.orElseThrow(()-> new CategoryNotFoundException("カテゴリが存在しません。"));
		categoryRepository.deleteById(categoryId);
	}
}
