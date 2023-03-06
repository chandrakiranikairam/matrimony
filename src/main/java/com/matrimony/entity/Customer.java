package com.matrimony.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue
	
	private Integer customerId;
	private String customerName;
	private Integer customerAge;
	private String customerCountry;
	private Double customerIncome;
	private String customerEducation;
	private String customerGender;
	private String customerCaste;
	private String customerProfession;
	private Long customerPhonenumber;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	public Double getCustomerIncome() {
		return customerIncome;
	}
	public void setCustomerIncome(Double customerIncome) {
		this.customerIncome = customerIncome;
	}
	public String getCustomerEducation() {
		return customerEducation;
	}
	public void setCustomerEducation(String customerEducation) {
		this.customerEducation = customerEducation;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerCaste() {
		return customerCaste;
	}
	public void setCustomerCaste(String customerCaste) {
		this.customerCaste = customerCaste;
	}
	public String getCustomerProfession() {
		return customerProfession;
	}
	public void setCustomerProfession(String customerProfession) {
		this.customerProfession = customerProfession;
	}
	
	public Long getCustomerPhonenumber() {
		return customerPhonenumber;
	}
	public void setCustomerPhonenumber(Long customerPhonenumber) {
		this.customerPhonenumber = customerPhonenumber;
	}
	public Customer(Integer customerId, String customerName, Integer customerAge, String customerCountry,
			Double customerIncome, String customerEducation, String customerGender, String customerCaste,
			String customerProfession, String customerFamilyDetails, Long customerPhonenumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerCountry = customerCountry;
		this.customerIncome = customerIncome;
		this.customerEducation = customerEducation;
		this.customerGender = customerGender;
		this.customerCaste = customerCaste;
		this.customerProfession = customerProfession;
		this.customerPhonenumber = customerPhonenumber;
	}
	public Customer(String customerName, Integer customerAge, String customerCountry, Double customerIncome,
			String customerEducation, String customerGender, String customerCaste, String customerProfession,
			 Long customerPhonenumber) {
		super();
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerCountry = customerCountry;
		this.customerIncome = customerIncome;
		this.customerEducation = customerEducation;
		this.customerGender = customerGender;
		this.customerCaste = customerCaste;
		this.customerProfession = customerProfession;
		this.customerPhonenumber = customerPhonenumber;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}