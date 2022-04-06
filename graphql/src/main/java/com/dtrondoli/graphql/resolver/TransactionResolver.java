package com.dtrondoli.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dtrondoli.domain.Account;
import com.dtrondoli.domain.Transaction;
import com.dtrondoli.service.AccountService;

@Component
public class TransactionResolver implements GraphQLResolver<Transaction>{
	
	private static final String DEPOSIT = "DEPOSIT";
	private static final String WITHDRAW = "WITHDRAW";
	
	@Autowired
	private AccountService accountService;
	
	public Account accountSource(Transaction a) {
		if(a.getType().equals(DEPOSIT)) {
			return null;
		}
		return getAccountById(a.getAccountSource().getId());
	}
	
	public Account accountTarget(Transaction a) {
		if(a.getType().equals(WITHDRAW)) {
			return null;
		}
		return getAccountById(a.getAccountTarget().getId());
	}
	
	private Account getAccountById(Long id) {
		return accountService.findById(id);
	}
}
