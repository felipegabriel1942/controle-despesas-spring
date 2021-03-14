package com.felipegabriel.controledespesas.service;

import java.util.List;

import com.felipegabriel.controledespesas.model.entity.TransactionType;

public interface TransactionTypeService {
	
	public List<TransactionType> getTypes();
}
