package com.cg.vehicleloanmanagement.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vehicleloanmanagement.entity.Account;
import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.ApprovedLoan;
import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.LoanApplicationStatusException;
import com.cg.vehicleloanmanagement.exception.ApprovedLoanException;
import com.cg.vehicleloanmanagement.exception.PendingLoanException;
import com.cg.vehicleloanmanagement.repository.AccountJPARepository;
import com.cg.vehicleloanmanagement.repository.LoanApplicationStatusJPARepository;
import com.cg.vehicleloanmanagement.repository.UserJpaRepository;
import com.cg.vehicleloanmanagement.service.ApprovedService;
import com.cg.vehicleloanmanagement.service.LoanApplicationService;
import com.cg.vehicleloanmanagement.service.UserService;

@RestController
public class ApprovedController {

	@Autowired
	private ApprovedService approveservice;

	//Creating approved application
	@PostMapping(path = "/approved/create")
	public ApprovedLoan createApprovedApplication(@RequestBody ApprovedLoan approvedloan) throws Exception
	{
		System.out.println(" Inside createApprovedApplication of Approved_Controller");
		ApprovedLoan approvedloanvalidated=approveservice.CreateApprovedLoan(approvedloan);
		return approvedloanvalidated;
	}
	
	
	//Retrieving all approved loans with emi details
	@GetMapping(path="/viewAllApproved")//get all approved laon_application
	public List<ApprovedLoan> retrieveAllApprovedLoans() throws ApprovedLoanException 
	{
		List<ApprovedLoan> approvedloans=approveservice.findAllApprovedLoans();
		return approvedloans;
	}
	//Deleting approved Loan
	@DeleteMapping(path="/delete/{id}")
	public void deleteapprovedLoan(@PathVariable ("id") int id)
	{
		System.out.println("insdie  deleteapprovedLoan deleted "+id);
		approveservice.deleteById(id);
	}
	
	
}
