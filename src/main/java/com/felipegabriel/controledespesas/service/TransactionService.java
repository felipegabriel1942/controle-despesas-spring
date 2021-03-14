package com.felipegabriel.controledespesas.service;

import org.springframework.data.domain.Page;

import com.felipegabriel.controledespesas.dto.TransactionFilterDTO;
import com.felipegabriel.controledespesas.model.entity.Transaction;

public interface TransactionService {
	
	public Transaction save(Transaction transaction);
	
	public Transaction update(Transaction transaction);
	
	public void delete(Integer id);
	
	public Page<Transaction> getTransactions(TransactionFilterDTO filter);
	
	public void validate(Transaction transaction);
	
	public boolean userIsValid(Transaction transaction);
	
	public boolean descriptionIsValid(Transaction transaction);
	
	public boolean valueIsValid(Transaction transaction);
	
	public boolean typeIsValid(Transaction transaction);
	
}
