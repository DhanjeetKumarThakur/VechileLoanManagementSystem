package com.cg.vehicleloanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vehicleloanmanagement.entity.LoanApplication;

public interface LoanApplicationJPARepository extends JpaRepository<LoanApplication, Integer>{

}
