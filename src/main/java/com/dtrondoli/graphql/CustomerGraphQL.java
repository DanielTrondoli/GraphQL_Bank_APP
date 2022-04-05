package com.dtrondoli.graphql;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dtrondoli.DTO.CustomerInput;
import com.dtrondoli.domain.Customer;
import com.dtrondoli.service.CustomerService;

@Component
public class CustomerGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver{
	
	private static final ModelMapper MAPPER = new ModelMapper();
	
	@Autowired
	private CustomerService service;
	
	public String hello() {
		return "Hello GraphQL";		
	}
	
	public Customer customer(Long id) {
		return service.findById(id);
	}
	
	public List<Customer> customers() {
		return service.findAll();
	}
	
	public Customer saveCustomer(CustomerInput ci){		
		Customer c = MAPPER.map(ci, Customer.class);		
		return service.save(c);
	}
	
	public boolean deleteCustomer(Long id) {
		return true;
	}
}
