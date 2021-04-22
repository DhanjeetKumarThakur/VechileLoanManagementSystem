package com.cg.vehicleloanmanagement;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.LoanApplicationException;
import com.cg.vehicleloanmanagement.repository.LoanApplicationJPARepository;
import com.cg.vehicleloanmanagement.repository.LoanIDao;
import com.cg.vehicleloanmanagement.service.LoanApplicationService;

import org.junit.Assert;


@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class LoanApplicationTest {

	@Mock
	private LoanApplicationJPARepository repos;
	
	@InjectMocks
	private LoanApplicationService loanapplicationservice;
	
	
	
	User userTest1=new User("neelesh@gmail.com", "1234567", "Neelesh", "Male", 23, 
			"9876543210", "Vaishnavi Towers", "Telanagan", "Hyd", 500060, "Private", 500000, "BCDEFGHI", "bcd");
	User userTest2=new User("ram@gmail.com", "098765", "ram", "Male", 23, 
			"0123456789", "Hima Towers", "Telanagan", "Hyd", 500060, "Private", 500000, "BCDEFGHI", "bcd");
	
	
	LoanApplication loanapplicationTest1= new LoanApplication(1,userTest1, 2, 500000.0, "Honda", "Es3", "Sedan", "Black", 450000.0,500000);

	@Test
	public void testcreateLoanApplication() throws Exception 
	{
		
		
		Mockito.when(repos.save(loanapplicationTest1)).thenReturn(loanapplicationTest1);
		//System.out.println(loanapplicationTest1);
		LoanApplication lo= repos.save(loanapplicationTest1);
		Assert.assertEquals(1, lo.getLoan_applicaton_id());
	}
	@Test
	public void testGetLoanApplicationById() throws Exception 
	{
		//ula1 = mock(UserLoanApplication.class);
		
		BDDMockito.given(repos.findById(1)).willReturn
		(Optional.of(new LoanApplication(1,userTest1, 2, 500000.0, "Honda", "Es3", "Sedan", "Black", 450000.0,500000)));
	}
	
	
	
	
	
}