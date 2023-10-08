package com.goalteller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goalteller.dto.AccountDto;
import com.goalteller.dto.TransactionDto;
import com.goalteller.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/account/{accountId}/transactions")
	public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto ,@PathVariable Integer accountId){
		
		TransactionDto createdTransaction = this.transactionService.createTransaction(transactionDto, accountId);
		
		return new ResponseEntity<TransactionDto>(createdTransaction,HttpStatus.CREATED);
		
	}
	@GetMapping("/account/{accountId}/transactions")
	public ResponseEntity<?> getAllTransactionByAccountId(@PathVariable Integer accountId){
		
		List<TransactionDto> transactionDtos = transactionService.getAllTransactionByAccountId(accountId);
		return new ResponseEntity<>(transactionDtos,HttpStatus.ACCEPTED);
		
	}

}
