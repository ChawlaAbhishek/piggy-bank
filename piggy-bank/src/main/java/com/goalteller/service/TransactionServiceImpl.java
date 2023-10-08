package com.goalteller.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goalteller.dao.AccountDao;
import com.goalteller.dao.TransactionDao;
import com.goalteller.dto.TransactionDto;
import com.goalteller.dto.UserDto;
import com.goalteller.entity.Account;
import com.goalteller.entity.Transaction;
import com.goalteller.exceptions.ResourceNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TransactionDto createTransaction(TransactionDto transactionDto, Integer accountId) {
		
      Account account = accountDao.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account does not exist with id"+" "+accountId));
		
		Transaction transaction = this.modelMapper.map(transactionDto, Transaction.class);
		
		transaction.setAccount(account);
		transaction.setTransactionDate(new Date());
		
		this.transactionDao.save(transaction);
		return this.modelMapper.map(transaction, TransactionDto.class);
		
	}

	@Override
	public List<TransactionDto> getAllTransactionByAccountId(Integer accountId) {
		
	      Account account = accountDao.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account does not exist with id"+" "+accountId));
		  List<Transaction> transactions =account.getTransaction();
		  List<TransactionDto> transactionDtos = transactions.stream().map((transaction)->modelMapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
           return transactionDtos;
	}

}
