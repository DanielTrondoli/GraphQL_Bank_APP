package com.dtrondoli.graphql;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dtrondoli.DTO.TransactionInput;
import com.dtrondoli.domain.Transaction;
import com.dtrondoli.domain.TransactionBuilder;
import com.dtrondoli.service.TransactionService;

@Component
public class TransactionGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	private static final ModelMapper MAPPER = new ModelMapper();

	@Autowired
	private TransactionService service;

	public Transaction transaction(Long id) {
		return service.findById(id);
	}

	public List<Transaction> transactions() {
		return service.findAll();
	}

	public Boolean deposit(Long targetId, float amount) {

		TransactionBuilder tb = new TransactionBuilder();
		tb.setTypeDeposit();
		tb.setAmount(amount);
		tb.setTarget(targetId);

		return service.save(tb.build()) != null;
	}

	public Boolean withdraw(Long sourceId, float amount) {

		TransactionBuilder tb = new TransactionBuilder();
		tb.setTypetWithdraw();
		tb.setAmount(amount);
		tb.setSource(sourceId);

		return service.save(tb.build()) != null;
	}
	
	public Boolean transfer(Long sourceId, Long targetId, float amount) {

		TransactionBuilder tb = new TransactionBuilder();
		tb.setTypeTransfer();
		tb.setAmount(amount);
		tb.setSource(sourceId);
		tb.setTarget(targetId);
		
		return service.save(tb.build()) != null;
	}

	public Transaction saveTransaction(TransactionInput ci) {
		Transaction c = MAPPER.map(ci, Transaction.class);
		c.setDate(LocalDateTime.now(ZoneOffset.UTC));
		return null;// service.save(c);
	}

	public boolean deleteTransaction(Long id) {
		return service.delete(id);
	}
}
