package com.dtrondoli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dtrondoli.domain.Account;
import com.dtrondoli.domain.Transaction;
import com.dtrondoli.kafka.producer.TransactionProducer;
import com.dtrondoli.repository.AccountRepository;
import com.dtrondoli.repository.TransactionRepository;

@Component
public class TransactionService {

	private static final String DEPOSIT = "DEPOSIT";
	private static final String WITHDRAW = "WITHDRAW";
	private static final String TRANSFER = "TRANSFER";
	private static final String OPEN = "OPEN";

	@Autowired
	private TransactionRepository repo;

	@Autowired
	private AccountRepository accountRepo;

	public Transaction findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Transaction> findAll() {
		return repo.findAll();
	}
	
	public Transaction save(Transaction t) {
		if (t.getAmount() < 0) {
			return null; // throw exception
		}

		String type = t.getType();
		switch (type) {
		case DEPOSIT:
			if (!validateDeposit(t)) {
				return null; // throw exception
			}
			break;
		case WITHDRAW:
			if (!validateWithdraw(t)) {
				return null; // throw exception
			}
			break;
		case TRANSFER:
			if (!validateTransfer(t)) {
				return null; // throw exception
			}
			break;
		default:
			return null;
		}
		
		t = repo.save(t);
		if(t== null) return t;
		
		TransactionProducer tp = new TransactionProducer();
		tp.sendTransaction(t);
		return t;
	}

	private boolean validateWithdraw(Transaction t) {

		if (t == null || !t.getType().equals(WITHDRAW)) {
			return false;
		}

		if (t.getAccountTarget() != null || t.getAccountSource() == null) {
			return false;
		}

		Optional<Account> source = accountRepo.findById(t.getAccountSource().getId());

		if (!source.isPresent()) {
			return false;
		}

		if (!source.get().getStatus().equals(OPEN)) {
			return false;
		}
		
		if ((source.get().getBalance() - t.getAmount()) < 0) {
			return false;
		}
		
		return true;
	}

	private boolean validateDeposit(Transaction t) {

		if (t == null || !t.getType().equals(DEPOSIT)) {
			return false;
		}

		if (t.getAccountTarget() == null || t.getAccountSource() != null) {
			return false;
		}

		Optional<Account> target = accountRepo.findById(t.getAccountTarget().getId());

		if (!target.isPresent()) {
			return false;
		}

		if (!target.get().getStatus().equals(OPEN)) {
			return false;
		}

		return true;
	}

	private boolean validateTransfer(Transaction t) {

		if (t == null || !t.getType().equals(TRANSFER)) {
			return false;
		}

		if (t.getAccountTarget() == null || t.getAccountSource() == null
				|| t.getAccountSource().getId().equals(t.getAccountTarget().getId())) {
			return false; // throw exception
		}

		Optional<Account> source = accountRepo.findById(t.getAccountSource().getId());
		Optional<Account> target = accountRepo.findById(t.getAccountTarget().getId());

		if (!source.isPresent() || !target.isPresent()) {
			return false;
		}

		if (!source.get().getStatus().equals(OPEN) || !target.get().getStatus().equals(OPEN)) {
			return false;
		}

		if ((source.get().getBalance() - t.getAmount()) < 0) {
			return false;
		}

		return true;
	}

	public boolean delete(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
}
