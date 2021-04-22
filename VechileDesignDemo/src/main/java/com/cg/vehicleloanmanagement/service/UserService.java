package com.cg.vehicleloanmanagement.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.UserException;
import com.cg.vehicleloanmanagement.repository.UserJpaRepository;
@Service
public class UserService implements UserIservice
{
	@Autowired
	//private UserJpaRepository userRepository;
	private UserJpaRepository userRepository;
	//Retrieving  all users
	@Override
	public List<User> findAllUsers() throws UserException
	{
		System.out.println("Inside findAll() of UserService");
		List<User> users = userRepository.findAll();
		if(users.isEmpty())
		{
			throw new UserException(" There are no users in the system ");
		}
		return users;
	}
	//Finding user using email 
	@Override
	public User findUser(String email)throws UserException {
		System.out.println("Inside findUser(String email) of User_Service");
		
		Optional<User> user = userRepository.findById(email);
		if (user.isPresent()) 
		{
            return user.get();
        } 
		throw new UserException("The user you are trying to fetch is not present");
	}
	//Saving user details
	@Override
	public User saveUser(User user) throws UserException
	{
		
		System.out.println("Inside save() of UserService");
		Optional<User> userdatabase=userRepository.findById(user.getUser_email());
		if (userdatabase.isPresent()) 
		{
			throw new UserException("User has already registered");
        } 
		else 
		{
			userRepository.save(user);
			return user;
        }

	}
	//Deleting user by using email
	@Override
	public void deleteOneUser(String email)
	{
		System.out.println("Inside deleteOneUser() of UserService");
		userRepository.deleteById(email);
	}
	@Override
	public User findUserphno(String phno) throws UserException {
		// TODO Auto-generated method stub
		List<User> users= userRepository.findAll();
		for(User u:users) {
			if(u.getUser_phone_Number().equals(phno));
		return u;
		}
		throw new UserException("Phone number not found");
	}
	


}
