package com.cg.vehicleloanmanagement;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.repository.LoanApplicationStatusJPARepository;
import com.cg.vehicleloanmanagement.service.ApplicationStatusService;


@SpringBootTest
public class ApplicationStatusTests {

	@Mock
	private LoanApplicationStatusJPARepository repos;
	
	@InjectMocks
	private ApplicationStatusService aservice;
	
	User u1 = new User("123@3445","eswar","EswarVarma","Male",20,"7890866","India","Telangana","Hyd",89098,"Dev",67890.0,"y78u9","hgf6879");
	LoanApplication l1=new LoanApplication(1,u1,200,500.0,"Hundai","i20","Petrol","red", 5000.0,2000.0);
	LoanApplicationStatus a1=new LoanApplicationStatus(2,"Pending",l1);
	
	User u2 = new User("123@345","eswar","Eswar","Male",18,"7897899","India","Telangana","Hyd",78964,"Dev",88790.0,"hd8dod","6e9e89");
	LoanApplication l2=new LoanApplication(2,u2,200,500.0,"Hundai","i20","Petrol","red", 5000.0,2000.0);
	LoanApplicationStatus a2=new LoanApplicationStatus(3,"Pending",l2);
	
	
	@Test
    public void testFindAllPendingApplications() throws Exception {
		List<LoanApplicationStatus> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		when(repos.findAll()).thenReturn(list);
		Assert.assertEquals(2,repos.findAll().size());
	}
	
	@Test
    public void testCreateApplicationStatus()throws Exception{
    	when(repos.save(a1)).thenReturn(a1);
    	LoanApplicationStatus a3 = repos.save(a1);
    	Assert.assertEquals("Pending",a3.getStatus());
    }
	
	@Test
    public void testFindApplicationStatusById()throws Exception{
    	BDDMockito.given(repos.findById(3)).willReturn
    	(Optional.of(new LoanApplicationStatus(3,"Pending",l2)));
		
    }
}