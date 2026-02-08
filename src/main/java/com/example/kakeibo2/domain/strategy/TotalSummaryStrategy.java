package com.example.kakeibo2.domain.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.kakeibo2.domain.entity.Transaction;

@Component
public class TotalSummaryStrategy implements SummaryStrategy{
	
	@Override
	public int summarize(List<Transaction> transaction) {
		return transaction.stream().mapToInt(val -> val.getAmount().getValue()).sum();	
	}
	
}
