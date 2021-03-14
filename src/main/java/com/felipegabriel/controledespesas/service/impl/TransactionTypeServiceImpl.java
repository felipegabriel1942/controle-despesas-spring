package com.felipegabriel.controledespesas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipegabriel.controledespesas.model.entity.TransactionType;
import com.felipegabriel.controledespesas.model.repository.TransactionTypeRepository;
import com.felipegabriel.controledespesas.service.TransactionTypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionTypeServiceImpl implements TransactionTypeService {
	
	private final TransactionTypeRepository repository;

	@Override
	public List<TransactionType> getTypes() {
		return repository.findAll();
	}
}
