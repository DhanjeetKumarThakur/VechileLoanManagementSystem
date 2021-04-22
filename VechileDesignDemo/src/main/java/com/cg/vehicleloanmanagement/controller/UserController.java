package com.cg.vehicleloanmanagement.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;

import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.UserException;
import com.cg.vehicleloanmanagement.service.UserService;
@RestController
public class UserController 
{
	@Autowired
	private UserService user_service;
	
	@PostMapping(path = "/user")
	public User createUser(@RequestBody @Valid User user,BindingResult bindingresult)
			throws UserException,Exception
	{
		System.out.println("Inside createUser(User user) of UserResource");
		if(bindingresult.hasErrors())
		{
			System.out.println("Errors");
			throw new UserException("User details are invalid");
			
		}
		
		User userValidated=user_service.saveUser(user);
		return userValidated;	
		
	}
	//Retrieving all users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() throws UserException 
	{
		System.out.println("Inside retrieveAllUsers() of UserResource");
		List<User> users = user_service.findAllUsers();
		return users;
	}
	//Retrieving user by email
	@GetMapping(path="/users/{email}")
	public User retrieveUser(@PathVariable ("email") String email)
			throws UserException
	{
		System.out.println("Inside retrieveUser(String email) of UserResource "+email);
		User user=user_service.findUser(email);
		return user;
	}
	
	@GetMapping(path="/users/phno/{phno}")
	public User retrieveUserPhno(@PathVariable("phno") String phno)
			throws UserException
	{
		User user=user_service.findUserphno(phno);
		return user;
	}
	
	
	//Delete user using email
	@DeleteMapping(path="/users/delete/{email}")
	public void deleteUser(@PathVariable ("email") String email)
	{
		System.out.println("Inside of deleteUser (String email) of UserResource "+email);
		user_service.deleteOneUser(email);
	}
	
}
