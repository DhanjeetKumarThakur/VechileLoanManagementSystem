package com.cg.vehicleloanmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vehicleloanmanagement.entity.Account;
import com.cg.vehicleloanmanagement.entity.ApprovedLoan;
import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.ApprovedLoanException;
import com.cg.vehicleloanmanagement.exception.LoanApplicationException;
import com.cg.vehicleloanmanagement.exception.LoanApplicationStatusException;
import com.cg.vehicleloanmanagement.exception.PendingLoanException;
import com.cg.vehicleloanmanagement.exception.UserException;
import com.cg.vehicleloanmanagement.repository.AccountJPARepository;
import com.cg.vehicleloanmanagement.repository.ApprovedLoanJPARepository;
@Service
public class ApprovedService
{
	@Autowired
	private ApprovedLoanJPARepository approvedIdao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountJPARepository account_repository;
	
	@Autowired
	private LoanApplicationService loanApplicationService;
	
	@Autowired
	private ApplicationStatusService applicationService;
	//Finding all approved loans
	public List<ApprovedLoan> findAllApprovedLoans()throws ApprovedLoanException {
		// TODO Auto-generated method stub
		List<ApprovedLoan> app=approvedIdao.findAll();
		if(app.isEmpty()) {
			throw new ApprovedLoanException("There are no approved loans to be viewed");
		}
		return app;
	}

//
//	E =P*R[((1+R)^n)/((1+R)^n)-1)]
//			  
//			  p ---> Principal amount---->Loan Application
//			  R ---> Rate of interest ----> Approved Loan
//			  n ----> 12* no of months ----> Loan Application
	
//	
//	public void emiCalculation()
//	{
//	   Loan_Application obj = new Loan_Application();
//	   Approved_Loan obj2 = new Approved_Loan();
//	   double p = obj.getLoan_amount();
//	   double r = obj2.getLoan_interest();
//	   double n = (double)(12*obj.getLoan_tenure());
//	   double mul = p*r;
//	   double v = Math.pow(r+1, n);
//	 //  double emi = (P*R)((Math.pow(R+1, n)/((Math.pow(R+1, n)-1)));
//	   
//	   double emi = mul*(v/(v-1));
//	}
	//Finding approved loan by Id
	public ApprovedLoan findApprovedLoanById(int approvedId)throws ApprovedLoanException {
		Optional<ApprovedLoan> approvedLoan=approvedIdao.findById(approvedId);
		if(approvedLoan.isPresent())
		{		
			return approvedLoan.get();
		}
		throw new ApprovedLoanException(" there is no approved loan with id "+approvedId);
	}
	//Creating Approved Loan
	public ApprovedLoan CreateApprovedLoan(ApprovedLoan approvedloan) throws PendingLoanException, LoanApplicationStatusException, UserException, LoanApplicationException, ApprovedLoanException
	{
		System.out.println("createApprovedLoan");
		LoanApplicationStatus appsta=null;
		
		
		List<ApprovedLoan> approvedloans=approvedIdao.findAll();
		for(ApprovedLoan a:approvedloans)
		{
			if(a.getApplication_status().getApplication_status_id()==approvedloan.getApplication_status().getApplication_status_id())
			{
				throw new ApprovedLoanException("Multiple Approved loan cannot be created for a single application id "+approvedloan.getApplication_status().getApplication_status_id());
			}
		}
		
		if(approvedloan!=null)
		{
			int applicationid=approvedloan.getApplication_status().getApplication_status_id();
			System.out.println("Application Id"+ applicationid);
			
			appsta=applicationService.findApplicationById(applicationid);
			if(appsta!=null)
			{
				if(appsta.getStatus().equalsIgnoreCase("Approved"))
				{
				  	
					
					LoanApplication loan_app =loanApplicationService.findById(appsta.getLaon_app().getLoan_applicaton_id());
					
					   double p = loan_app.getLoan_amount();
					   
					   double r =approvedloan.getLoan_interest();
					   double n = (double)(12*loan_app.getLoan_tenure());
					   double mul = p*r;
					   double v = Math.pow(r+1, n);
					 //  double emi = (P*R)((Math.pow(R+1, n)/((Math.pow(R+1, n)-1)));
					   
					   double emi = mul*(v/(v-1));
					   System.out.println("p :"+p+" r :"+r+" n :"+n+" mul :"+mul+" v :"+v+" emi : "+emi);
					   approvedloan.setEmi_amount(emi);
					   
					User approvedUser=userService.findUser(loan_app.getUser().getUser_email());
					System.out.println("*************** "+approvedloan);
					ApprovedLoan ap=approvedIdao.save(approvedloan);
					Account a=new Account();
					a.setLoanapp(loan_app);
					a.setUser(approvedUser);
					account_repository.save(a);
					System.out.println(a);
					return ap;
				}
				else
					{
						throw new PendingLoanException("Pending Loan");
					}
			}
				else
			{
					throw new LoanApplicationStatusException("Loan with the given application id is not valid ");
			}
		}
		throw new ApprovedLoanException("Details cannot be null");
}
		
	//delete approved loan by Id
	public void deleteById(int approvedId) {
		// TODO Auto-generated method stub
		approvedIdao.deleteById(approvedId);
		
	}


}
