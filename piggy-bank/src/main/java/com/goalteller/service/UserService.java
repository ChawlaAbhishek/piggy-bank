package com.goalteller.service;

import java.util.List;

import com.goalteller.dto.UserDto;
import com.goalteller.exceptions.ResourceNotFoundException;



public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Integer userId) throws ResourceNotFoundException;
	UserDto getUserById(Integer userId) throws ResourceNotFoundException;
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId) throws ResourceNotFoundException;

}
