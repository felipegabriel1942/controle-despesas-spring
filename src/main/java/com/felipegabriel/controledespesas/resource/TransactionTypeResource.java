package com.felipegabriel.controledespesas.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.controledespesas.model.entity.TransactionType;
import com.felipegabriel.controledespesas.service.TransactionTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/type")
@RequiredArgsConstructor
public class TransactionTypeResource {

	private final TransactionTypeService service;

	@GetMapping
	public List<TransactionType> getTypes() {
		try {
			return service.getTypes();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar tipos de transação.");
		}
	}
}
