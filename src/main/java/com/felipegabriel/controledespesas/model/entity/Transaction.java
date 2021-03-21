package com.felipegabriel.controledespesas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions", schema = "public")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	@Column(name = "transaction_date")
	private LocalDate transactionDate;

	private BigDecimal value;

	private Boolean fixed;

	private Integer installment;

	@Column(name = "total_installments")
	private Integer totalInstallments;

	@Column(name = "main_transaction")
	private Integer mainTransaction;

	@ManyToOne
	@JoinColumn(name = "transaction_category")
	private TransactionCategory category;

	@ManyToOne
	@JoinColumn(name = "transaction_type")
	private TransactionType type;
	
	@ManyToOne
	@JoinColumn(name = "transaction_user")
	private User user;
}
