package com.dtrondoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtrondoli.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
