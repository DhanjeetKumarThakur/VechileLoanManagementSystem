package com.cg.vehicleloanmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.cg.vehicleloanmanagement.entity.LoanApplication;

public interface LoanIDao {

	public Optional<LoanApplication> findById(int loan_appId);
	public LoanApplication save(LoanApplication loan_app);
	public void deleteById(int loan_appid);
	public List<LoanApplication> findAll();
}
