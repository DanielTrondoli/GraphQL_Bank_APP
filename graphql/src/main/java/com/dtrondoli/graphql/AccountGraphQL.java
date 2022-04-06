package com.dtrondoli.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dtrondoli.DTO.AccountInput;
import com.dtrondoli.domain.Account;
import com.dtrondoli.service.AccountService;

@Component
public class AccountGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver{
	
	private static final ModelMapper MAPPER = new ModelMapper();
	
	@Autowired
	private AccountService service;
	
	public Account account(Long id) {
		return service.findById(id);
	}
	
	public List<Account> accounts() {
		return service.findAll();
	}
	
	public Account saveAccount(AccountInput ci){
		Account c = MAPPER.map(ci, Account.class);		
		return service.save(c);
	}
	
	public boolean deleteAccount(Long id) {
		return service.delete(id);
	}
	
	public boolean attBalance(Long id, Float newBalance) {
		return service.attBalance(id, newBalance) != null;
	}
}
