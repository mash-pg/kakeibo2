package com.example.kakeibo2.domain.strategy;

import org.springframework.stereotype.Component;

import com.example.kakeibo2.domain.valueobject.TransactionType;

@Component
public class SummaryStrategyProvider {
	public SummaryStrategy getStrategy(String type) {
		return switch(type) {
		
			case "total" -> new TotalSummaryStrategy();
			
			case "income" -> new TypeSummaryStrategy(TransactionType.INCOME);
			
			case "expense" -> new TypeSummaryStrategy(TransactionType.EXPENSE);
			
			default -> throw new IllegalArgumentException("Unknown type : " + type);
		};
	}
}
