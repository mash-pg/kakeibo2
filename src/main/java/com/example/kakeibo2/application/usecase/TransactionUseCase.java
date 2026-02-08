package com.example.kakeibo2.application.usecase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.exception.CategoryNotFoundException;
import com.example.kakeibo2.domain.exception.TransactionNotFoundException;
import com.example.kakeibo2.domain.factory.TransactionFactory;
import com.example.kakeibo2.domain.repository.CategoryRepository;
import com.example.kakeibo2.domain.repository.TransactionRepository;
import com.example.kakeibo2.domain.strategy.SummaryStrategy;
import com.example.kakeibo2.domain.strategy.SummaryStrategyProvider;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.TransactionId;

@Service
public class TransactionUseCase {

    private final TransactionFactory transactionFactory;
	
	private final TransactionRepository transactionRepository;
	private final CategoryRepository categoryRepository; 
	
	private final SummaryStrategyProvider provider;
	public TransactionUseCase(
			TransactionRepository transactionRepository,
			CategoryRepository categoryRepository, 
			TransactionFactory transactionFactory
			,SummaryStrategyProvider provider){
		this.transactionRepository = transactionRepository;
		this.categoryRepository = categoryRepository;
		this.transactionFactory = transactionFactory;
		this.provider = provider;
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
		transactionRepository.findById(new TransactionId(id)).orElseThrow(()-> new TransactionNotFoundException("トランザクションが存在してません"));
		Transaction transaction = 
				transactionFactory.createForUpdate(
						id,
						type, 
						amount, 
						categoryId, 
						description, 
						transactionDate
						);
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
		categoryRepository.findById(new CategoryId(categoryId)).orElseThrow(()-> new CategoryNotFoundException("カテゴリが存在してません"));
		Transaction transaction = 
				transactionFactory.createNew(
						type, 
						amount, 
						categoryId, 
						description, 
						transactionDate
						);
		return transactionRepository.save(transaction);
	}
	
	@Transactional
	public void deleteById(Long id) {
		TransactionId tranId = new TransactionId(id);
		transactionRepository.findById(tranId).orElseThrow(()-> new TransactionNotFoundException("トランザクションが存在してません"));
		transactionRepository.deleteById(tranId);
	}
	
	public int summarize(String summaryType) {
		List<Transaction> transaction = transactionRepository.findAll();
		SummaryStrategy strategy = provider.getStrategy(summaryType);
		return strategy.summarize(transaction);
	}
}
