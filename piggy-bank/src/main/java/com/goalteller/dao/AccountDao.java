package com.goalteller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goalteller.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
