package com.cg.vehicleloanmanagement.service;

import com.cg.vehicleloanmanagement.entity.LoanApplication;
import com.cg.vehicleloanmanagement.entity.User;
import com.cg.vehicleloanmanagement.exception.LoanApplicationException;

public interface LoanIService 
{
	public LoanApplication createLoanApplication(LoanApplication loan_application);
	public LoanApplication findById(int id)throws LoanApplicationException;
	public LoanApplication getLoanApplication(int loan_appId)throws LoanApplicationException;
	public void deleteLoanApplication(int loan_appid);
}
