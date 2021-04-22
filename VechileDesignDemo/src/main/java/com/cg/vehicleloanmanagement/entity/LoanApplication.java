package com.cg.vehicleloanmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Entity
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loan_applicaton_id;
	@OneToOne
	@JoinColumn(name="user_email")
	private User user;
	
	//max =5 msg=years
	@Max(value=5)
	private int loan_tenure;
	
	
	//min = 500000 max=1500000
	@Min(value=500000) 
	@Max(value=1500000)
	private double loan_amount;

	@Pattern(regexp ="[a-zA-Z]+")
	private String vehicle_brand;
	
	@Pattern(regexp ="[a-zA-Z0-9]+")
	private String vehicle_model;
	
	@Pattern(regexp ="[a-zA-Z]+")
	private String vehicle_type;
	
	@Pattern(regexp ="[a-zA-Z]+")
	private String vehicle_colour;
	
	
	private double vehicle_exshowroom_price;
	
	private double vehicel_on_road_price;
	
	//Default constructor
	public LoanApplication() 
	{	
		super();
	}
	
	//Parameterized Constructor
	public LoanApplication(int loan_applicaton_id, User user, @Max(5) int loan_tenure,
			@Min(500000) @Max(1500000) double loan_amount, @Pattern(regexp = "[a-zA-Z]+") String vehicle_brand,
			@Pattern(regexp = "[a-zA-Z0-9]+") String vehicle_model, @Pattern(regexp = "[a-zA-Z]+") String vehicle_type,
			@Pattern(regexp = "[a-zA-Z]+") String vehicle_colour, double vehicle_exshowroom_price,
			double vehicel_on_road_price) {
		super();
		this.loan_applicaton_id = loan_applicaton_id;
		this.user = user;
		this.loan_tenure = loan_tenure;
		this.loan_amount = loan_amount;
		this.vehicle_brand = vehicle_brand;
		this.vehicle_model = vehicle_model;
		this.vehicle_type = vehicle_type;
		this.vehicle_colour = vehicle_colour;
		this.vehicle_exshowroom_price = vehicle_exshowroom_price;
		this.vehicel_on_road_price = vehicel_on_road_price;
	}


	//Overriding toString
	@Override
	public String toString() {
		return "Loan_Application [loan_applicaton_id=" + loan_applicaton_id + ", user=" + user + ", loan_tenure="
				+ loan_tenure + ", loan_amount=" + loan_amount + ", vehicle_brand=" + vehicle_brand + ", vehicle_model="
				+ vehicle_model + ", vehicle_type=" + vehicle_type + ", vehicle_colour=" + vehicle_colour
				+ ", vehicle_exshowroom_price=" + vehicle_exshowroom_price + ", vehicel_on_road_price="
				+ vehicel_on_road_price + "]";
	}

	//Setters and Getters

	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public int getLoan_applicaton_id() {
		return loan_applicaton_id;
	}

	public void setLoan_applicaton_id(int loan_applicaton_id) {
		this.loan_applicaton_id = loan_applicaton_id;
	}

	
	

	public int getLoan_tenure() {
		return loan_tenure;
	}

	public void setLoan_tenure(int loan_tenure) {
		this.loan_tenure = loan_tenure;
	}

	public double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public String getVehicle_brand() {
		return vehicle_brand;
	}

	public void setVehicle_brand(String vehicle_brand) {
		this.vehicle_brand = vehicle_brand;
	}

	public String getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_colour() {
		return vehicle_colour;
	}

	public void setVehicle_colour(String vehicle_colour) {
		this.vehicle_colour = vehicle_colour;
	}

	public double getVehicle_exshowroom_price() {
		return vehicle_exshowroom_price;
	}

	public void setVehicle_exshowroom_price(double vehicle_exshowroom_price) {
		this.vehicle_exshowroom_price = vehicle_exshowroom_price;
	}

	public double getVehicel_on_road_price() {
		return vehicel_on_road_price;
	}

	public void setVehicel_on_road_price(double vehicel_on_road_price) {
		this.vehicel_on_road_price = vehicel_on_road_price;
	}




	


	
	


}
