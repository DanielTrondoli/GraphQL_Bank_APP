package com.dtrondoli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dtrondoli.domain.Customer;
import com.dtrondoli.repository.CustomerRepository;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Customer> findAll() {
		return repo.findAll();
	}

	public Customer save(Customer c) {
		return repo.save(c);
	}
	
	public boolean delete(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}		
		return false;
	}
}
