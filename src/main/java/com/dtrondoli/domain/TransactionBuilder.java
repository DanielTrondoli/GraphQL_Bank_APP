package com.dtrondoli.domain;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TransactionBuilder {

	private Long id;

	private LocalDateTime date;
	private double amount;
	private String status;
	private String type;
	private Account accountSource;
	private Account accountTarget;

	public TransactionBuilder() {
		this.status = "CREATED";
		this.date = LocalDateTime.now(ZoneOffset.UTC);
	}	
	
	public TransactionBuilder setTypeDeposit() {
		this.type = "DEPOSIT";
		return this;
	}
	
	public TransactionBuilder setTypeTransfer() {
		this.type = "TRANSFER";		
		return this;
	}
	
	public TransactionBuilder setTypetWithdraw() {
		this.type = "WITHDRAW";		
		return this;
	}
	
	public TransactionBuilder setAmount(float amount) {
		this.amount = amount;
		return this;		
	}
	
	public TransactionBuilder setTarget(Long targetId) {
		Account target = new Account();
		target.setId(targetId);
		this.accountTarget = target;
		return this;
	}
	
	public TransactionBuilder setSource(Long sourceId) {
		Account source = new Account();
		source.setId(sourceId);
		this.accountSource = source;
		return this;
	}
	
	public Transaction build() {
		return new Transaction(null, date, amount, status, type, accountSource, accountTarget);
	}
}
