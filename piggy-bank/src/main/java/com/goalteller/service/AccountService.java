package com.goalteller.service;

import com.goalteller.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto,Integer userId);
	
	Integer withdrawMoney (Integer accountId);
	

}