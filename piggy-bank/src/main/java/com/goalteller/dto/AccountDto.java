package com.goalteller.dto;

import java.util.Date;

import com.goalteller.entity.User;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	
	
	private Long accountNumber;
	
	private String status;
	
    private Date date;
	
	private UserDto user;

}
