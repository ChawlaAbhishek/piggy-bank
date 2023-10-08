package com.goalteller.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goalteller.dao.UserDao;
import com.goalteller.dto.UserDto;
import com.goalteller.entity.User;
import com.goalteller.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public UserDto createUser(UserDto userDto) {
		
	User user =	this.modelMapper.map(userDto, User.class);
	User newUser = this.userDao.save(user);
	return this.modelMapper.map(newUser, UserDto.class);

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) throws ResourceNotFoundException {
		
        User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("user does not exist with"+" " +userId));
		
		user.setName(userDto.getName());
		user.setAddress(userDto.getAddress());
		
		User updatedUser = userDao.save(user);
		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Integer userId) throws ResourceNotFoundException {
		
        User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("user does not exist with"+" " +userId));
        
        return this.modelMapper.map(user, UserDto.class);

	}

	@Override
	public List<UserDto> getAllUsers() {
         List<User> users = userDao.findAll();
		
		List<UserDto> userDtos = users.stream().map((user)->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) throws ResourceNotFoundException {
		
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User do not exist with"+" "+userId));
		userDao.delete(user);
		
	}

}
