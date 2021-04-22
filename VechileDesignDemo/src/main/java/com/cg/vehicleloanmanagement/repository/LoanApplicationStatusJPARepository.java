package com.cg.vehicleloanmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vehicleloanmanagement.entity.LoanApplicationStatus;
@Repository
public interface LoanApplicationStatusJPARepository extends JpaRepository<LoanApplicationStatus, Integer>
{
}
