package com.cg.vehicleloanmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.LoanApplicationException;
import com.cg.vehicleloanmanagement.repository.LoanApplicationStatusJPARepository;
import com.cg.vehicleloanmanagement.repository.LoanIDao;
import com.cg.vehicleloanmanagement.repository.LoanApplicationJPARepository;

@Service
public class LoanApplicationService implements LoanIService
{

	@Autowired
	private LoanApplicationJPARepository loanrepository;
	

	@Autowired 
	private ApplicationStatusService appservice;
	
	//Creating loan application
	@Override
	public LoanApplication createLoanApplication(LoanApplication loan_application) 
	{
		
			LoanApplication loan_app=loanrepository.save(loan_application);
			LoanApplicationStatus a=new LoanApplicationStatus();
			a.setStatus("Pending");
			a.setLaon_app(loan_app);
			appservice.createApplicationStatus(loan_app);
			return loan_app;
		
	}
	//Get loan application by Id
	@Override
	public LoanApplication getLoanApplication(int loan_appId)
			throws LoanApplicationException{
		// TODO Auto-generated method stub
		Optional<LoanApplication> loanapp = loanrepository.findById(loan_appId);
		if (loanapp.isPresent()) 
		{
            return loanapp.get();
        } 
		throw new LoanApplicationException("The loan application which you are trying to fetch is not present in the system");
	}
	//Delete loan application by Id
	@Override
	public void deleteLoanApplication(int loan_appid) {
		// TODO Auto-generated method stub
	
		loanrepository.deleteById(loan_appid);
		
	}
	//Finding loan application by ID
	@Override
	public LoanApplication findById(int id)
			throws LoanApplicationException
	{
		// TODO Auto-generated method stub
		
		Optional<LoanApplication>l= loanrepository.findById(id);
		if(l.isPresent())
		{
			return l.get();
		}
		throw new LoanApplicationException("There is no Loan Application with given Id");
	}
	//Finding loan application by email
	public User findLoanByEmail(String email) {//throws LoanApplicationException {
		// TODO Auto-generated method stub
		List<LoanApplication> allloans=loanrepository.findAll();
		for(LoanApplication l:allloans)
		{
			if(l.getUser().getUser_email().equals(email))
			{
				return l.getUser();
			}
		}
//		throw new LoanApplicationException("There is no Loan Application with given Email");
		return null;
	}
	


}
