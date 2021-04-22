package com.cg.vehicleloanmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.exception.LoanApplicationStatusException;
import com.cg.vehicleloanmanagement.repository.LoanApplicationStatusJPARepository;
import com.cg.vehicleloanmanagement.service.ApplicationStatusService;

@RestController
public class LoanApplicationStatusController {
	
	@Autowired
	private ApplicationStatusService applicationSttausService;
	//update status of loan application
	@PutMapping(value = "status/update/{id}")
	public LoanApplicationStatus updateStatus(@RequestBody LoanApplicationStatus app,@PathVariable("id") int appid) throws LoanApplicationStatusException
	{
		System.out.println("Inside updateStatus() of Application_controller");
		LoanApplicationStatus Validatedapplication = applicationSttausService.updateApplicationStatus (appid, app);
		return 	Validatedapplication;
	}
	
	
	//Finding application status by Id
	@GetMapping(value= "/status/{id}")
	public LoanApplicationStatus findApplicationStatusById(@PathVariable("id") int id) throws LoanApplicationStatusException,Exception
	{
		System.out.println("inside findapplication by id of applicationStatus controller");
		LoanApplicationStatus applicationstatus=applicationSttausService.findApplicationById(id);
		return applicationstatus;
	}
	
	//Retrieve all loan applications based on approved
	@GetMapping(value="/status/approved")
	public List<LoanApplicationStatus> getApproved() throws Exception
	{
		List<LoanApplicationStatus> AllApprovedapplications =applicationSttausService.findAllApprovedApplications();
		return AllApprovedapplications;
	}
	
	//Retrieve all loan applications based on rejected

	@GetMapping(value="/status/rejected")
	public List<LoanApplicationStatus> getRejected() throws Exception
	{
		List<LoanApplicationStatus> AllRejectedApplications=applicationSttausService.findAllRejectedApplications();
		return AllRejectedApplications;
		
	}
	
	//Retrieve all Loan applications which are pending
	@GetMapping(value="/status/pending")
	public List<LoanApplicationStatus> getPending() throws Exception
	{
		List<LoanApplicationStatus> AllPendingApplications=applicationSttausService.findAllPendingApplications();
		return AllPendingApplications;
		
	}
	
	

}
