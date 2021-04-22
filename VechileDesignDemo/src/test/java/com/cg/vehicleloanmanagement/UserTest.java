package com.cg.vehicleloanmanagement;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.UserException;
import com.cg.vehicleloanmanagement.repository.UserIDao;
import com.cg.vehicleloanmanagement.repository.UserJpaRepository;
import com.cg.vehicleloanmanagement.service.UserService;

import org.junit.Assert;


@SpringBootTest
public class UserTest {

	@Mock
	private UserJpaRepository repository;
	
	@InjectMocks
	private UserService userService;
	
	//User Creation
	User u1 = new User("123@3445","eswar","EswarVarma","Male",20,"7890866","India","Telangana","Hyd",89098,"Dev",67890.0,"y78u9","hgf6879");
    User u2 = new User("123@345","eswar","EswarVarma","Male",20,"7890866","India","Telangana","Hyd",89098,"Dev",67890.0,"y78u9","hgf6879");
   
  
    @Test
    public void testSaveUser()throws Exception{
    	Mockito.when(userService.saveUser(u1)).thenReturn(u1);
    	User u3 = userService.saveUser(u1);
    	Assert.assertEquals("123@3445",u3.getUser_email());
    }
    
    @Test
    public void testGetAllUsers() throws Exception {
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		when(repository.findAll()).thenReturn(list);
		Assert.assertEquals(2,repository.findAll().size());
	}
    
    @Test
    public void testGetUserById()throws Exception{
    	when(repository.findById("123@345")).thenReturn(Optional.of(u2));
		User ula4=repository.findById("123@345").get();
		Assert.assertEquals("123@345", ula4.getUser_email());
    }
    

	 
}