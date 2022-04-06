package com.dtrondoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtrondoli.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
