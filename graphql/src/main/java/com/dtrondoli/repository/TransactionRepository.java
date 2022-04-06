package com.dtrondoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtrondoli.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
