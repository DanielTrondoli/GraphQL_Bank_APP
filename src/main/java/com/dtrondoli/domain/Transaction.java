package com.dtrondoli.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime date;
	private double amount;
	private String status;
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_source", nullable = true)
	private Account accountSource;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_target", nullable = true)
	private Account accountTarget;

	public Transaction() {
	}

	public Transaction(Long id, LocalDateTime date, double amount, String status, String type, Account accountSource,
			Account accountTarget) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.status = status;
		this.type = type;
		this.accountSource = accountSource;
		this.accountTarget = accountTarget;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account getAccountSource() {
		return accountSource;
	}

	public void setAccountSource(Account accountSource) {
		this.accountSource = accountSource;
	}

	public Account getAccountTarget() {
		return accountTarget;
	}

	public void setAccountTarget(Account accountTarget) {
		this.accountTarget = accountTarget;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
