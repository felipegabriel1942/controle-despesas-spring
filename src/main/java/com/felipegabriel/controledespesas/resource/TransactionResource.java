package com.felipegabriel.controledespesas.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
