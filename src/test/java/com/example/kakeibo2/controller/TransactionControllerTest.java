package com.example.kakeibo2.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.kakeibo2.application.usecase.TransactionUseCase;
import com.example.kakeibo2.presentation.controller.TransactionController;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private TransactionUseCase useCase;

	@Test
	void findAll_正常にリストを取得できる() throws Exception{
		
		//モックの設定
		when(useCase.findAll()).thenReturn(List.of());
		
		//実行と検証
		mockMvc.perform(get("/api/transactions"))
		.andExpect(status().isOk());
	
	}
}
