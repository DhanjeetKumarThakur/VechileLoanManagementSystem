package com.cg.vehicleloanmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {
	@Id
	//@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Email must contain @")
	private String user_email;
	
	@Size(min=6,max=8,message="Combination of ALL Character")
	@Pattern(regexp="[a-zA-Z0-9|,@#!-]+")
	private String user_password;
	
	@Pattern(regexp="[a-zA-Z]+",message="Name will contain only character")
	private String user_full_Name;
	
	@Pattern(regexp="[a-zA-Z]+")
	private String user_gender;
	
	
	private int user_age;
	
	@Size(min=10,message="Must be 10 in Size")
	@Pattern(regexp="[1-9]{1}[0-9]{9}+")
	private String user_phone_Number;
	
	@Pattern(regexp="[a-zA-Z0-9]+")
	private String user_address;
	
	@Pattern(regexp="[a-zA-Z ]+")
	private String user_state;
	
	@Pattern(regexp="[A-Za-z]+")
	private String user_city;
	
	
	private int user_pincode;
	
	//@Pattern(regexp="[A-Za-z]+")
	private String user_employement_type;
	
	private double user_salary;
	
	@Size(min=10)
	@Pattern(regexp="[1-9]{1}[0-9]{11}+")
	private String user_adhar_no;
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}+")
	private String user_pan_no;
	//Default constructor
	public User() {
		super();
	}
	
	
	//Parameterized constructor
	public User(String user_email, String user_password, String user_full_Name, String user_gender, int user_age,
			String user_phone_Number, String user_address, String user_state, String user_city, int user_pincode,
			String user_employement_type, double user_salary, String user_adhar_no, String user_pan_no) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_full_Name = user_full_Name;
		this.user_gender = user_gender;
		this.user_age = user_age;
		this.user_phone_Number = user_phone_Number;
		this.user_address = user_address;
		this.user_state = user_state;
		this.user_city = user_city;
		this.user_pincode = user_pincode;
		this.user_employement_type = user_employement_type;
		this.user_salary = user_salary;
		this.user_adhar_no = user_adhar_no;
		this.user_pan_no = user_pan_no;
	}

	
	//Setters and Getters
	public String getUser_employement_type() {
		return user_employement_type;
	}



	public void setUser_employement_type(String user_employement_type) {
		this.user_employement_type = user_employement_type;
	}



	public double getUser_salary() {
		return user_salary;
	}



	public void setUser_salary(double user_salary) {
		this.user_salary = user_salary;
	}



	public String getUser_adhar_no() {
		return user_adhar_no;
	}



	public void setUser_adhar_no(String user_adhar_no) {
		this.user_adhar_no = user_adhar_no;
	}



	public String getUser_pan_no() {
		return user_pan_no;
	}



	public void setUser_pan_no(String user_pan_no) {
		this.user_pan_no = user_pan_no;
	}



	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_full_Name() {
		return user_full_Name;
	}

	public void setUser_full_Name(String user_full_Name) {
		this.user_full_Name = user_full_Name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_phone_Number() {
		return user_phone_Number;
	}

	public void setUser_phone_Number(String user_phone_Number) {
		this.user_phone_Number = user_phone_Number;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public int getUser_pincode() {
		return user_pincode;
	}

	public void setUser_pincode(int user_pincode) {
		this.user_pincode = user_pincode;
	}
}