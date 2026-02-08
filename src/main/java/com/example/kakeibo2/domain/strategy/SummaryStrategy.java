package com.example.kakeibo2.domain.strategy;

import java.util.List;

import com.example.kakeibo2.domain.entity.Transaction;

public interface SummaryStrategy {
	int summarize(List<Transaction> transaction);
}
