package com.example.kakeibo2.presentation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakeibo2.application.usecase.TransactionUseCase;
import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.presentation.dto.TransactionRequest;
import com.example.kakeibo2.presentation.dto.TransactionResponse;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	private final TransactionUseCase useCase;
	
	public TransactionController(TransactionUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping
	public ResponseEntity<List<TransactionResponse>> findAll(){
		List<Transaction> tranList = useCase.findAll();
		List<TransactionResponse> response = 
				tranList.stream().map(TransactionResponse::fromEntity).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<TransactionResponse> create(
			@RequestBody TransactionRequest request
			){
		Transaction transaction = useCase.create(
					request.getType(),
					request.getAmount(),
					request.getCategoryId(),
					request.getDescription(),
					request.getTransactionDate()
				);
		TransactionResponse response = TransactionResponse.fromEntity(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TransactionResponse> update(
			@RequestBody TransactionRequest request,
			@PathVariable Long id
			){
		Transaction transaction = useCase.update(
				id,
				request.getType(),
				request.getAmount(),
				request.getCategoryId(),
				request.getDescription(),
				request.getTransactionDate()
				);
		TransactionResponse response = TransactionResponse.fromEntity(transaction);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(
			@PathVariable Long id
			){
		useCase.deleteById(id);		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/summary")
	public ResponseEntity<Integer> summarize(
			@RequestParam String type
			){
		int result = useCase.summarize(type);
		
		return ResponseEntity.ok(result);
	}
	

}
