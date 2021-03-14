package com.felipegabriel.controledespesas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipegabriel.controledespesas.model.entity.TransactionCategory;
import com.felipegabriel.controledespesas.model.repository.TransactionCategoryRepository;
import com.felipegabriel.controledespesas.service.TransactionCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionCategoryServiceImpl implements TransactionCategoryService{
	
	private final TransactionCategoryRepository repository;

	@Override
	public List<TransactionCategory> getCategories() {
		return repository.findAll();
	}
}
