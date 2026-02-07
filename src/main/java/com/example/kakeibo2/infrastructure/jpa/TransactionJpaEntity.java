package com.example.kakeibo2.infrastructure.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.valueobject.Amount;
import com.example.kakeibo2.domain.valueobject.CategoryId;
import com.example.kakeibo2.domain.valueobject.TransactionId;
import com.example.kakeibo2.domain.valueobject.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="transactions")
@Getter
@Setter
public class TransactionJpaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	private Integer amount;
	private Long categoryId;
	private String description;
	private LocalDate transactionDate;
	private LocalDateTime createdAt;

	public TransactionJpaEntity() {}

	public TransactionJpaEntity(
			Long id,
			String type, 
			Integer amount,
			Long categoryId,
			String description, 
			LocalDate transactionDate, 
			LocalDateTime createdAt 
			) {
			this.id = id;
			this.type = type;
			this.amount = amount;
			this.categoryId = categoryId;
			this.description = description;
			this.transactionDate = transactionDate;
			this.createdAt = createdAt;
	}
	
	//JPA Entity→Domain
	public Transaction toDomainEntity() {
		return new Transaction(
				new TransactionId(id), 
				TransactionType.from(type),
				new Amount(amount),
				new CategoryId(categoryId),
				description, 
				transactionDate, 
				createdAt);
	}
	
	//Domain→JPA Entity
	public static TransactionJpaEntity fromDomainEntity(Transaction transaction) {
		Long id = transaction.getId().getValue();
		String type = transaction.getType().name();
		Integer amount = transaction.getAmount().getValue();
		Long categoryId = transaction.getCategoryId().getValue();
		String description = transaction.getDescription();
		LocalDate transactionDate = transaction.getTransactionDate();
		LocalDateTime createdAt = transaction.getCreatedAt();
		
		return new TransactionJpaEntity(
				id,
				type,
				amount,
				categoryId,
				description,
				transactionDate,
				createdAt
				);
	}
}
