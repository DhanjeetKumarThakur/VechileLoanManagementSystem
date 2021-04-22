package com.cg.vehicleloanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vehicleloanmanagement.entity.Account;
@Repository
public interface AccountJPARepository extends JpaRepository<Account, Integer> {

}
