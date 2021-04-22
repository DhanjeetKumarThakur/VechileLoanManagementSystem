package com.cg.vehicleloanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.vehicleloanmanagement.entity.ApprovedLoan;

import antlr.collections.List;
@Repository
public interface ApprovedLoanJPARepository extends JpaRepository<ApprovedLoan, Integer>
{
	
}
