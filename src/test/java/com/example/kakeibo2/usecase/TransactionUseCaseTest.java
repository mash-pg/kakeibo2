package com.example.kakeibo2.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.kakeibo2.application.usecase.TransactionUseCase;
import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.factory.TransactionFactory;
import com.example.kakeibo2.domain.repository.CategoryRepository;
import com.example.kakeibo2.domain.repository.TransactionRepository;
import com.example.kakeibo2.domain.strategy.SummaryStrategyProvider;

@ExtendWith(MockitoExtension.class)
public class TransactionUseCaseTest {
	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private TransactionFactory transactionFactory;

	@Mock
	private SummaryStrategyProvider summaryStrategyProvider;

	@InjectMocks
	private TransactionUseCase useCase;

	@Test
	void findAll_正常にリストを取得できる() {
	    //モックの振る舞いを定義
		when(transactionRepository.findAll()).thenReturn(List.of());
	  
		//実行
		List<Transaction> result = useCase.findAll();
		//検証
		//nullじゃないか確認
		assertNotNull(result);
		//結果が0かどうかの確認
		assertEquals(0, result.size());
		//findAllが呼ばれたか確認
		verify(transactionRepository).findAll();
	}
}
