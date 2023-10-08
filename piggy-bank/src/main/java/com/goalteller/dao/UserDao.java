package com.goalteller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goalteller.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
