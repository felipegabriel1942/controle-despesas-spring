package com.felipegabriel.controledespesas.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.controledespesas.dto.TransactionFilterDTO;
import com.felipegabriel.controledespesas.exceptions.BusinessException;
import com.felipegabriel.controledespesas.model.entity.Transaction;
import com.felipegabriel.controledespesas.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionResource {

	private final TransactionService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction save(@RequestBody Transaction transaction) {
		try {
			return service.save(transaction);
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar");
		}
	}

	@GetMapping
	public Page<Transaction> getTransactions(@RequestParam Integer userId) {
		try {
			TransactionFilterDTO filter = TransactionFilterDTO.builder().userId(userId).build();
			return service.getTransactions(filter);
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar transações");
		}
	}
}
