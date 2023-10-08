package com.goalteller.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goalteller.dao.AccountDao;
import com.goalteller.dao.UserDao;
import com.goalteller.dto.AccountDto;
import com.goalteller.entity.Account;
import com.goalteller.entity.Transaction;
import com.goalteller.entity.User;
import com.goalteller.exceptions.ResourceNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountDto createAccount(AccountDto accountDto, Integer userId) {
		
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User does not exist with id"+" "+userId));
		
		Account account = this.modelMapper.map(accountDto, Account.class);
		
		account.setUser(user);
		account.setStatus("active");
		account.setDate(new Date());
		
		Account newAccount =this.accountDao.save(account);
		
		return this.modelMapper.map(newAccount, AccountDto.class);
		
		
		
	}

	@Override
	public Integer withdrawMoney(Integer accountId) {
		
		Account account =accountDao.findById(accountId).orElseThrow(()->new ResourceNotFoundException("account does not exist with id"+" " +accountId));
		account.setStatus("inactive");
		User user =account.getUser();
		Integer userId = user.getId();
		List<Transaction> transactions =account.getTransaction();
		Integer money = 0;
		 for (Transaction transaction : transactions) {
			 money+=transaction.getAmount();
		 }
		 deleteAccount(account.getStatus(),account,userId);
		  return money;
		 
		
	}

	public void deleteAccount(String status,Account account,Integer userId) {
		
			accountDao.delete(account);
			this.createAccount(this.modelMapper.map(account, AccountDto.class), userId);

		}

}
