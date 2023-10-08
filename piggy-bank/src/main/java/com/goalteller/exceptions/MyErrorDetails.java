package com.goalteller.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private boolean success;

}
