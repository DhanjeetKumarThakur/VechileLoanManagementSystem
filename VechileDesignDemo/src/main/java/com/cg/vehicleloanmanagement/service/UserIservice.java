package com.cg.vehicleloanmanagement.service;

import java.util.List;

import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.UserException;

public interface UserIservice {

	public List<User> findAllUsers()throws UserException;
	public User findUser(String email)throws UserException;
	public User saveUser(User user) throws UserException;
	public void deleteOneUser(String email);
	
	public User findUserphno(String phno) throws UserException;
}
