package com.cg.vehicleloanmanagement.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.LoanApplicationException;
import com.cg.vehicleloanmanagement.exception.UserException;
import com.cg.vehicleloanmanagement.repository.LoanApplicationStatusJPARepository;
import com.cg.vehicleloanmanagement.service.LoanApplicationService;
import com.cg.vehicleloanmanagement.service.UserService;

@RestController
public class LoanApplicationController 
{

	@Autowired
	private LoanApplicationService loanservice;
	
	//Create loan application
	@PostMapping(path = "/loan/apply")
	public LoanApplication createLoanApplication( @RequestBody @Valid LoanApplication loan_application,BindingResult bindingresult) 
			throws LoanApplicationException
	{
		System.out.println("Inside createLoanApplication of Loan_Application_Controller");
		if(bindingresult.hasErrors())
		{
			System.out.println("Errors");
			throw new LoanApplicationException("Loan application details are invalid");
		}
		
		if(loanservice.findLoanByEmail(loan_application.getUser().getUser_email())==null)
		{
			LoanApplication loan=loanservice.createLoanApplication(loan_application);
			return loan;
		}
		else
		{
			throw new LoanApplicationException("Users has already applied for loan, one user can have only one loan application");
		}
		
	}
	//Retrieving loan application by Id
	@GetMapping(path="/loan/get/{id}")
	public LoanApplication retrieveLoanApplicationbyId(@PathVariable("id") int  loan_appId) 
			throws LoanApplicationException
	{
		System.out.println("Inside retrieveLoanApplication() of Loan_Application_Controller");
		LoanApplication loanapp=loanservice.getLoanApplication(loan_appId);
		return loanapp;
	}
	//Deleting loan application by Id
	@DeleteMapping(path="/loan/delete/{id}")
	public void deleteLoanApplicationbyId(@PathVariable("id") int loan_appid)
	{
		System.out.println("Inside deleteLoanApplication() of Loan_Application_Controller");
		loanservice.deleteLoanApplication(loan_appid);
	}
	
//	@GetMapping(path="/loan/users/get/{email}")
//	public User retrieveLoanbyEmail(@PathVariable("email") String email) 
//			throws LoanApplicationException
//	{
//		System.out.println("Inside retrieveUserbyEmail()  of Loan_Application_Controller");
//		User user=loanservice.findLoanByEmail(email);
//		return user;
//		
//	}
	

}
