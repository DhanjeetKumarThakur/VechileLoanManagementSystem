package com.cg.vehicleloanmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LoanApplicationStatus 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int application_status_id;
	private String status;
	@OneToOne
	@JoinColumn(name="loan_applicaton_id")
	private LoanApplication laon_app;
	//Default constructor
	public LoanApplicationStatus() {
		super();
	}
	
	
	//Parameterized constructor
	public LoanApplicationStatus(int application_status_id, String status, LoanApplication laon_app) 
	{
		this.application_status_id = application_status_id;
		this.status = status;
		this.laon_app = laon_app;
	}
	//Overriding toDtring
	@Override
	public String toString() {
		return "Application_status [application_status_id=" + application_status_id + ", status=" + status
				+ ", laon_app=" + laon_app + "]";
	}

	//Setters and Getters
	public int getApplication_status_id() {
		return application_status_id;
	}
	public void setApplication_status_id(int application_status_id) {
		this.application_status_id = application_status_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoanApplication getLaon_app() {
		return laon_app;
	}
	public void setLaon_app(LoanApplication laon_app) {
		this.laon_app = laon_app;
	}



	
	

}
