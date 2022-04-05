package com.dtrondoli.DTO;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dtrondoli.domain.Account;

public class TransactionInput {
	
	private Long id;

	private LocalDateTime date;
	private double amount;
	private String status;
	private String type;
	private Long accountSourceID;
	private Long accountTargetID;

	public TransactionInput() {}

	public TransactionInput(Long id, LocalDateTime date, double amount, String status, Long accountSourceID,
			Long accountTargetID) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.status = status;
		this.accountSourceID = accountSourceID;
		this.accountTargetID = accountTargetID;
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

	public Long getAccountSourceID() {
		return accountSourceID;
	}

	public void setAccountSourceID(Long accountSourceID) {
		this.accountSourceID = accountSourceID;
	}

	public Long getAccountTargetID() {
		return accountTargetID;
	}

	public void setAccountTargetID(Long accountTargetID) {
		this.accountTargetID = accountTargetID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
}
