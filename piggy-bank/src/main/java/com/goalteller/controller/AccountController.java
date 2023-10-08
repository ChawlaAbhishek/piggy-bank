package com.goalteller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.goalteller.dto.AccountDto;
import com.goalteller.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/user/{userId}/accounts")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto ,@PathVariable Integer userId){
		
		AccountDto createdAccount = this.accountService.createAccount(accountDto, userId);
		
		return new ResponseEntity<AccountDto>(createdAccount,HttpStatus.CREATED);
		
	}
	@GetMapping("/accounts/{accountId}")
	public ResponseEntity<?> withdrawMoney(@PathVariable Integer accountId){
		
	Integer money =accountService.withdrawMoney(accountId);
	
	return new ResponseEntity<>("piggy bank breaked ,get your money"+" " +"rupees"+" "+money,HttpStatus.ACCEPTED);
		
		
		
	}

}
