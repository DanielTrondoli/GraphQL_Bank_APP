package com.dtrondoli.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dtrondoli.domain.Account;
import com.dtrondoli.domain.Customer;
import com.dtrondoli.service.CustomerService;

@Component
public class AccountResolver implements GraphQLResolver<Account>{

	@Autowired
	private CustomerService customerService;
	
	public Customer customer(Account a) {
		return customerService.findById(a.getCustomer().getId());
	}
}
