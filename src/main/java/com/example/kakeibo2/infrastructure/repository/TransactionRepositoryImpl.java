package com.example.kakeibo2.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.kakeibo2.domain.entity.Transaction;
import com.example.kakeibo2.domain.repository.TransactionRepository;
import com.example.kakeibo2.domain.valueobject.TransactionId;
import com.example.kakeibo2.infrastructure.jpa.TransactionJpaEntity;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{

	private final TransactionJpaRepository jpaRepository;
	
	public TransactionRepositoryImpl(TransactionJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}
	@Override
	public List<Transaction> findAll() {
		//jpa→domain
		List<TransactionJpaEntity> jparepository = jpaRepository.findAll();
		return jparepository.stream().map(jpa-> jpa.toDomainEntity()).collect(Collectors.toList());
		
	}

	@Override
	public Optional<Transaction> findById(TransactionId id) {
		Optional<TransactionJpaEntity> jparepository = jpaRepository.findById(id.getValue());
		return jparepository.map(jpa-> jpa.toDomainEntity());
	}

	@Override
	public Transaction save(Transaction transaction) {
		//domian→jpa
		TransactionJpaEntity jpaEntity = TransactionJpaEntity.fromDomainEntity(transaction);
		TransactionJpaEntity saved = jpaRepository.save(jpaEntity);
		
		return saved.toDomainEntity();
	}

	@Override
	public void deleteById(TransactionId id) {
		jpaRepository.deleteById(id.getValue());
	}

}
