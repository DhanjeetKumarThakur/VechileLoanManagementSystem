package com.cg.vehicleloanmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.cg.vehicleloanmanagement.entity.ApprovedLoan;


public interface ApprovedLoanIDao {

	public List<ApprovedLoan> findAll();
	public Optional<ApprovedLoan> findById(int approvedId);
	public ApprovedLoan save(ApprovedLoan approLoan);
	public void deleteById(int approvedId);
}
