package com.felipegabriel.controledespesas.service.impl;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.felipegabriel.controledespesas.dto.TransactionFilterDTO;
import com.felipegabriel.controledespesas.exceptions.BusinessException;
import com.felipegabriel.controledespesas.model.entity.Transaction;
import com.felipegabriel.controledespesas.model.repository.TransactionRepository;
import com.felipegabriel.controledespesas.service.TransactionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository repository;

	@Override
	public Transaction save(Transaction transaction) {
		validate(transaction);
		return repository.save(transaction);
	}

	@Override
	public Transaction update(Transaction transaction) {
		Objects.nonNull(transaction.getId());
		validate(transaction);
		return repository.save(transaction);
	}

	@Override
	public void validate(Transaction transaction) {
		if (!userIsValid(transaction)) {
			throw new BusinessException("Informe um usuário cadastrado.");
		}

		if (!descriptionIsValid(transaction)) {
			throw new BusinessException("Informe uma descrição para a transação.");
		}

		if (!valueIsValid(transaction)) {
			throw new BusinessException("Informe valor válido e acima de 0.");
		}

		if (!typeIsValid(transaction)) {
			throw new BusinessException("Informe um tipo para a transação.");
		}

	}

	@Override
	public boolean userIsValid(Transaction transaction) {
		return transaction.getUser() != null && transaction.getUser().getId() != null;
	}

	@Override
	public boolean descriptionIsValid(Transaction transaction) {
		return transaction.getDescription() != null && transaction.getDescription() != "";
	}

	@Override
	public boolean valueIsValid(Transaction transaction) {
		return transaction.getValue() != null && transaction.getValue().compareTo(BigDecimal.ZERO) == 1;
	}

	@Override
	public boolean typeIsValid(Transaction transaction) {
		return transaction.getType() != null && transaction.getType().getId() != null;
	}

	@Override
	public void delete(Integer id) {
		Transaction transaction = repository.findById(id).get();
		Objects.nonNull(transaction);
		repository.delete(transaction);

	}

	@Override
	public Page<Transaction> getTransactions(TransactionFilterDTO filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
