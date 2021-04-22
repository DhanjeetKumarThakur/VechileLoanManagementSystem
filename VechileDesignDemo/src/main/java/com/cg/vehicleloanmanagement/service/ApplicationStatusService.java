package com.cg.vehicleloanmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.exception.LoanApplicationStatusException;
import com.cg.vehicleloanmanagement.repository.LoanApplicationStatusJPARepository;

@Service
public class ApplicationStatusService {
	@Autowired
	private LoanApplicationStatusJPARepository apprespo;
	//update application status
	public LoanApplicationStatus updateApplicationStatus(int applicationId,LoanApplicationStatus app)
			throws LoanApplicationStatusException
	{
		System.out.println("isndie Update Application status "+applicationId);
		Optional<LoanApplicationStatus >applicationTobeValidated=	apprespo.findById(applicationId);
		LoanApplicationStatus appstatus=null;
		if(applicationTobeValidated.isPresent())
		{
			String updatedStatus=app.getStatus();//to get the status updated in post
			appstatus=applicationTobeValidated.get();
			appstatus.setStatus(updatedStatus);
			apprespo.save(appstatus);
			return appstatus;
		}
		throw new LoanApplicationStatusException("Application cannot be modified as there is no application with the id "+applicationId);
			
	}
	//Finding all approved applications
	public List<LoanApplicationStatus> findAllApprovedApplications()throws LoanApplicationStatusException {
		
		List<LoanApplicationStatus> AllApplicationsList =  apprespo.findAll();//finds all applications in the application Table
		List<LoanApplicationStatus> returnapproved=new ArrayList<LoanApplicationStatus>();
		for(LoanApplicationStatus as: AllApplicationsList) {
			if(as.getStatus().equalsIgnoreCase("approved")) {
				returnapproved.add(as);
			}
		}
		if(returnapproved.isEmpty()) {
			throw new LoanApplicationStatusException("There are no Approved Applications");
		}
		return returnapproved;
	}
	//Finding all rejected applications
	public List<LoanApplicationStatus> findAllRejectedApplications()throws LoanApplicationStatusException 
	{
		
		List<LoanApplicationStatus> AllApplicationsList = apprespo.findAll();//finds all applications in the application Table
		List<LoanApplicationStatus> returnrejected=new ArrayList<LoanApplicationStatus>();
		for(LoanApplicationStatus as: AllApplicationsList) {
			if(as.getStatus().equalsIgnoreCase("rejected")) {
				returnrejected.add(as);
			}
		}
		if(returnrejected.isEmpty()) {
			throw new LoanApplicationStatusException("There are no Rejected Applications");
		}
		return returnrejected;
	}
	//Finding all pending applications
	public List<LoanApplicationStatus> findAllPendingApplications()throws LoanApplicationStatusException {
		
		List<LoanApplicationStatus> AllApplicationsList = apprespo.findAll();//finds all applications in the application Table
		List<LoanApplicationStatus> returnpending=new ArrayList<LoanApplicationStatus>();
		for(LoanApplicationStatus as: AllApplicationsList) {
			if(as.getStatus().equalsIgnoreCase("pending")) {
				returnpending.add(as);
			}
		}
		if(returnpending.isEmpty()) {
			throw new LoanApplicationStatusException("There are no pending Applications");
		}
		return returnpending;
	}
	//finding application by Id
	public LoanApplicationStatus findApplicationById(int id) throws LoanApplicationStatusException {
		System.out.println("inside findApplicationById ");
		Optional<LoanApplicationStatus> applicationstatus=apprespo.findById(id);
		if(applicationstatus.isPresent())
		{
			System.out.println(applicationstatus.get());
			return applicationstatus.get();
		}
		throw new LoanApplicationStatusException("application Status cannot be viewed as there is no application with "+id);
		
	}
	//Creating application status 
	public LoanApplicationStatus createApplicationStatus(LoanApplication loan_app)
	{
		LoanApplicationStatus application=new LoanApplicationStatus();
		application.setStatus("Pending");
		application.setLaon_app(loan_app);
		apprespo.save(application);
		return application;
	}

}
