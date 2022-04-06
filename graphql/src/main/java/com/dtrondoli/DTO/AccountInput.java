package com.dtrondoli.DTO;

import com.dtrondoli.domain.Customer;

public class AccountInput {

	private Long id;
	private double balance;
	private String status;
	private Long customerID;

	public AccountInput() {
	}

	public AccountInput(Long id, double balance, String status, Long customerID) {
		this.id = id;
		this.balance = balance;
		this.status = status;
		this.customerID = customerID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}	
}
