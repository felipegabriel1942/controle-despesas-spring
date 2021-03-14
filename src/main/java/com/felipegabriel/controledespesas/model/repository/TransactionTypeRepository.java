package com.felipegabriel.controledespesas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.controledespesas.model.entity.TransactionType;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer>{

}
