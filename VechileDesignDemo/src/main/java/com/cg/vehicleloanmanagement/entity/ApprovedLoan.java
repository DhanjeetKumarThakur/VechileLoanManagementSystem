package com.cg.vehicleloanmanagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
	@Entity
	public class ApprovedLoan {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int approved_id;
		
		 
		private double emi_amount;
		
		private double loan_interest;
		
		@Temporal(value = TemporalType.DATE)
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date emi_starting_date;
		//private LocalDate emi_starting_date;
		
		@OneToOne
		@JoinColumn(name="application_status_id")
		private LoanApplicationStatus application_status;
		//Default constructor
		public ApprovedLoan() {
			super();
		}
		
		//Parameterized Constructor
		public ApprovedLoan(int approved_id, double emi_amount, double loan_interest,LoanApplicationStatus application_status) {
			super();
			this.approved_id = approved_id;
			this.emi_amount = emi_amount;
			this.loan_interest = loan_interest;
			this.application_status = application_status;
		}


		//Overriding toString
		@Override
		public String toString() {
			return "Approved_Loan [approved_id=" + approved_id + ", emi_amount=" + emi_amount + ", loan_interest="
					+ loan_interest + ", emi_starting_date=" + emi_starting_date + ", application_status="
					+ application_status + "]";
		}
		//Setters and Getters
		public int getApproved_id() {
			return approved_id;
		}
		public void setApproved_id(int approved_id) {
			this.approved_id = approved_id;
		}
		public double getEmi_amount() {
			return emi_amount;
		}
		public void setEmi_amount(double emi_amount) {
			this.emi_amount = emi_amount;
		}
		public double getLoan_interest() {
			return loan_interest;
		}
		public void setLoan_interest(double d) {
			this.loan_interest = d;
		}
		public Date getEmi_starting_date() {
			return emi_starting_date;
		}
		public void setEmi_starting_date(Date emi_starting_date) {
			this.emi_starting_date = emi_starting_date;
		}
		
		public LoanApplicationStatus getApplication_status() {
			return application_status;
		}
		public void setApplication_status(LoanApplicationStatus application_status) {
			this.application_status = application_status;
		}
		
	
		
		
		

}
