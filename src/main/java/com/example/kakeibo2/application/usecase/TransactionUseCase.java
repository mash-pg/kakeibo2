package com.example.kakeibo2.application.usecase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.exception.CategoryNotFoundException;
import com.example.kakeibo2.domain.exception.TransactionNotFoundException;
import com.example.kakeibo2.domain.repository.CategoryRepository;
import com.example.kakeibo2.domain.repository.TransactionRepository;
import com.example.kakeibo2.domain.valueobject.Amount;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.TransactionId;
import com.example.kakeibo2.domain.valueobject.TransactionType;

@Service
public class TransactionUseCase {
	
	private final TransactionRepository transactionRepository;
	private final CategoryRepository categoryRepository; 
	
	public TransactionUseCase(TransactionRepository transactionRepository,CategoryRepository categoryRepository){
		this.transactionRepository = transactionRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public List<Transaction> findAll(){
		return transactionRepository.findAll();
		
	}
	@Transactional
	public Transaction update(
			Long id,
			String type,
			int amount,
			Long categoryId,
			String description,
			LocalDate transactionDate) {
		TransactionType tranType = TransactionType.from(type);
		TransactionId tranId = new TransactionId(id);
		CategoryId catId = new CategoryId(categoryId);
		Amount amt = new Amount(amount);
		transactionRepository.findById(tranId).orElseThrow(()-> new TransactionNotFoundException("トランザクションが存在してません"));
		Transaction transaction = 
				new Transaction(tranId, tranType, amt,catId, description, transactionDate, null);
		return transactionRepository.save(transaction);
	}
	
	@Transactional
	public Transaction create(
			String type,
			int amount,
			Long categoryId,
			String description,
			LocalDate transactionDate
			) {
		TransactionType tranType = TransactionType.from(type);
		CategoryId catId = new CategoryId(categoryId);
		Amount amt = new Amount(amount);
		categoryRepository.findById(catId).orElseThrow(()-> new CategoryNotFoundException("カテゴリが存在してません"));
		Transaction transaction = new Transaction(null, tranType, amt, catId, description, transactionDate, null);
		return transactionRepository.save(transaction);
	}
	
	@Transactional
	public void deleteById(Long id) {
		TransactionId tranId = new TransactionId(id);
		transactionRepository.findById(tranId).orElseThrow(()-> new TransactionNotFoundException("トランザクションが存在してません"));
		transactionRepository.deleteById(tranId);
	}
}
