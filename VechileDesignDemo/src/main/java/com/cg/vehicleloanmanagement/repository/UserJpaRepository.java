package com.cg.vehicleloanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vehicleloanmanagement.entity.User;

@Repository
public interface UserJpaRepository extends  JpaRepository<User, String>
{

}
