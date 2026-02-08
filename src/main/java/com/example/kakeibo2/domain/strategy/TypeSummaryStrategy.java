package com.example.kakeibo2.domain.strategy;

import java.util.List;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.valueobject.TransactionType;

public class TypeSummaryStrategy implements SummaryStrategy{
	private final TransactionType targetType;
	public TypeSummaryStrategy(TransactionType targetType) {
		this.targetType = targetType;
	}
	
	@Override
	public int summarize(List<Transaction> transaction) {
		
		return transaction.stream()
				.filter(t -> t.getType() == targetType)
				.mapToInt(val -> val.getAmount().getValue())
				.sum();
	}
	
	
}
