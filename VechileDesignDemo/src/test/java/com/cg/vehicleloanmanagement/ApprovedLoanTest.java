package com.cg.vehicleloanmanagement;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vehicleloanmanagement.entity.ApprovedLoan;
import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.repository.ApprovedLoanIDao;
import com.cg.vehicleloanmanagement.repository.ApprovedLoanJPARepository;
import com.cg.vehicleloanmanagement.service.ApprovedService;


@SpringBootTest
public class ApprovedLoanTest {

	@Mock
	private ApprovedLoanJPARepository repos;
	
	@InjectMocks
	private ApprovedService aservice;
	
	User u1 = new User("123@3445","eswar","EswarVarma","Male",20,"7890866","India","Telangana","Hyd",89098,"Dev",67890.0,"y78u9","hgf6879");
	LoanApplication l1=new LoanApplication(1,u1,200,500.0,"Hundai","i20","Petrol","red", 5000.0,2000.0);
	LoanApplicationStatus a1=new LoanApplicationStatus(2,"approved",l1);
	ApprovedLoan s1=new ApprovedLoan(3,200.0,20.0,a1);
	
	@Test
    public void testGetAllApprovedLoans() throws Exception {
		List<ApprovedLoan> list = new ArrayList<>();
		list.add(s1);
		when(repos.findAll()).thenReturn(list);
		Assert.assertEquals(1,repos.findAll().size());
	}
	
	@Test
    public void testGetApprovedLoanById()throws Exception{
    	BDDMockito.given(repos.findById(3)).willReturn
    	(Optional.of(new ApprovedLoan(3,200.0,20.0,a1)));
		
    }
	
	 @Test
	    public void testSaveApprovedLoan()throws Exception{
	    	when(repos.save(s1)).thenReturn(s1);
	    	ApprovedLoan a3 = repos.save(s1);
	    	Assert.assertEquals(3,a3.getApproved_id());
	    }
	

}