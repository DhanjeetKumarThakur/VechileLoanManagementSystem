package com.cg.vehicleloanmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.cg.vehicleloanmanagement.entity.User;



public interface UserIDao {
	public List<User> findAll();
	public Optional<User> findById(String email);
	public User save(User user);
	public void deleteById(String email);
	public User findOne(String phoneno);
	//public void create_User(User user);
	
}
