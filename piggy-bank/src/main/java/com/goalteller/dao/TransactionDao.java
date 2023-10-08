package com.goalteller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goalteller.entity.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
