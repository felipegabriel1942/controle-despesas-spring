package com.felipegabriel.controledespesas.service;

import java.util.List;

import com.felipegabriel.controledespesas.model.entity.TransactionCategory;

public interface TransactionCategoryService {
	
	public List<TransactionCategory> getCategories();
}
