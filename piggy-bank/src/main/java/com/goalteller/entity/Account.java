package com.goalteller.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	
	private String status;
	
	private Date date;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transaction;
	
}
