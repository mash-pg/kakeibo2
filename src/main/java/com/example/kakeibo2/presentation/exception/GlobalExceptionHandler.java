package com.example.kakeibo2.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kakeibo2.domain.exception.CategoryInUseException;
import com.example.kakeibo2.domain.exception.CategoryNotFoundException;
import com.example.kakeibo2.domain.exception.InvalidAmountException;
import com.example.kakeibo2.domain.exception.InvalidCategoryNameException;
import com.example.kakeibo2.domain.exception.InvalidTransactionTypeException;
import com.example.kakeibo2.domain.exception.TransactionNotFoundException;
import com.example.kakeibo2.presentation.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTransactionNotFound(TransactionNotFoundException e){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse(e.getMessage()));
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException e){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse(e.getMessage()));
	}
	
	@ExceptionHandler(InvalidAmountException.class)
	public ResponseEntity<ErrorResponse> handleInvalidAmountException(InvalidAmountException e){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(e.getMessage()));
	}
	
	@ExceptionHandler(CategoryInUseException.class)
	public ResponseEntity<ErrorResponse> handleCategoryInUseException(CategoryInUseException e){
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(new ErrorResponse(e.getMessage()));
	}
	
	@ExceptionHandler(InvalidTransactionTypeException.class)
	public ResponseEntity<ErrorResponse> handleInvalidTransactionTypeException(InvalidTransactionTypeException e){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(e.getMessage()));
	}
	
	@ExceptionHandler(InvalidCategoryNameException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCategoryNameException(InvalidCategoryNameException e){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(e.getMessage()));
	}
}
