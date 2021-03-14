package com.felipegabriel.controledespesas.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.controledespesas.model.entity.TransactionCategory;
import com.felipegabriel.controledespesas.service.TransactionCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class TransactionCategoryResource {
	
	private final TransactionCategoryService service;
	
	public List<TransactionCategory> getCategories() {
		try {
			return service.getCategories();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar categorias.");
		}
	}
}
