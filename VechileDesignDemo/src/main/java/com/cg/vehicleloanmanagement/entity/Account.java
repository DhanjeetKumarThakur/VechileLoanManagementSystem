package com.cg.vehicleloanmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Account_number;
	@OneToOne
	@JoinColumn(name="user_email")
	private User user;
	@OneToOne
	@JoinColumn(name="loan_applicaton_id")
	private LoanApplication loanapp;
	//Default constructor
	public Account() {
		super();
	}
	//Overriding toString
	@Override
	public String toString() {
		return "Account [Account_number=" + Account_number + ", user=" + user + ", loanapp=" + loanapp + "]";
	}
	
	//Setters and Getters
	public int getAccount_number() {
		return Account_number;
	}

	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoanApplication getLoanapp() {
		return loanapp;
	}

	public void setLoanapp(LoanApplication loanapp) {
		this.loanapp = loanapp;
	}

	
	

}
