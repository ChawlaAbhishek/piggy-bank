package com.goalteller.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goalteller.dto.UserDto;
import com.goalteller.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> saveUser( @RequestBody UserDto userDto) {
		
		UserDto createdUserDto =  userService.createUser(userDto);
		
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto ,@PathVariable("userId") Integer userId){
		UserDto updatedUserDto = userService.updateUser(userDto, userId);
		
		return new ResponseEntity<UserDto>(updatedUserDto,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
		return "user deleted successfully";
	}
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
		
		List<UserDto> userDtos= userService.getAllUsers();
		
		return new ResponseEntity<>(userDtos,HttpStatus.OK);
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Integer userId){
		
		UserDto userDto = userService.getUserById(userId);
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}

}
