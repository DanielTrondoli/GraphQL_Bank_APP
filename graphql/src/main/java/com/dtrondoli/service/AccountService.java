package com.dtrondoli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaCountQueryCreator;
import org.springframework.stereotype.Component;

import com.dtrondoli.domain.Account;
import com.dtrondoli.repository.AccountRepository;

@Component
public class AccountService {

	@Autowired
	private AccountRepository repo;

	public Account findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Account> findAll() {
		return repo.findAll();
	}

	public Account save(Account c) {
		return repo.save(c);
	}

	public Account attBalance(Long id, float newBalance) {

		Optional<Account> opt = repo.findById(id);
		if (opt.isPresent()) {
			Account ac = opt.get();
			ac.setBalance(newBalance);
			return repo.save(ac);
		}
		
		return null;
	}

	public boolean delete(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
}
