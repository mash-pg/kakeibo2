package com.example.kakeibo2.domain.factory;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.valueobject.Amount;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.TransactionId;
import com.example.kakeibo2.domain.valueobject.TransactionType;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TransactionFactory {

	public Transaction createNew(
			String type,
			int amount,
			Long categoryId,
			String description,
			LocalDate transactionDate	
			) {
		//VO変換
		TransactionType tranType = TransactionType.from(type);
		Amount amt = new Amount(amount);
		CategoryId catId = new CategoryId(categoryId);
		log.info("Transaction created: {} : {} : {}"
				,tranType , amt , catId);
		return new Transaction(
				null, 
				tranType, 
				amt, 
				catId, 
				description, 
				transactionDate, 
				null);
	}
	
	public Transaction createForUpdate(
			Long id,
			String type,
			int amount,
			Long categoryId,
			String description,
			LocalDate transactionDate
			) {
		//VO変換
		TransactionId tranId = new TransactionId(id);
		TransactionType tranType = TransactionType.from(type);
		Amount amt = new Amount(amount);
		CategoryId catId = new CategoryId(categoryId);
		
		return   new Transaction(
				tranId, 
				tranType, 
				amt, 
				catId, 
				description, 
				transactionDate, 
				null
		);
		

	}
}
