package com.goalteller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goalteller.dto.TransactionDto;

@Service
public interface TransactionService {
	
	TransactionDto createTransaction(TransactionDto transactionDto, Integer accountId);
	
	List<TransactionDto> getAllTransactionByAccountId(Integer accountId);

}
