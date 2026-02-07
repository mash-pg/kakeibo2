package com.example.kakeibo2.domain.exception;


public class InvalidTransactionTypeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidTransactionTypeException(String message) {
		super(message);
	}
}
