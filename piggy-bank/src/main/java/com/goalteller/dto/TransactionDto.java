package com.goalteller.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
	
    private Integer id;
	
	private Integer amount;
	
	private Date transactionDate;
	
	private AccountDto account;

}
