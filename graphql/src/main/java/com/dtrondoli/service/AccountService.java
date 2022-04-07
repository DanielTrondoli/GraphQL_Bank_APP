package com.dtrondoli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaCountQueryCreator;
import org.springframework.stereotype.Component;

import com.dtrondoli.domain.Account;
import com.dtrondoli.domain.Transaction;
import com.dtrondoli.repository.AccountRepository;
import com.dtrondoli.repository.TransactionRepository;

@Component
public class AccountService {

	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private TransactionRepository transactionRepo;

	public Account findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Account> findAll() {
		return repo.findAll();
	}

	public Account save(Account c) {
		return repo.save(c);
	}

	public Account attBalance(Long transactionId, Long accountId, float newBalance) {
		
		Optional<Transaction> optTr = transactionRepo.findById(transactionId);
		
		if (optTr.isPresent()) {
			Transaction trans = optTr.get();
			trans.setStatus("PROCESSED");
			transactionRepo.save(trans);
		}else {
			return null;
		}
		
		Optional<Account> optAc = repo.findById(accountId);
		if (optAc.isPresent()) {
			Account ac = optAc.get();
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
