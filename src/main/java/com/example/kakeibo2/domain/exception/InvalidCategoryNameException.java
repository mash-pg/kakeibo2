package com.example.kakeibo2.domain.exception;

public class InvalidCategoryNameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCategoryNameException(String message) {
		super(message);
	}
}
