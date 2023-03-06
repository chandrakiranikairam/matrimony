package com.matrimony.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mediator {
	
	@Id
	@GeneratedValue
	private Integer mediatorId;
	private String name;
    private Long mobileNo;
    
	public Mediator() {
		super();
	}

	public Mediator(Integer mediatorId, String name, Long mobileNo) {
		super();
		this.mediatorId = mediatorId;
		this.name = name;
		this.mobileNo = mobileNo;
	}

	public Mediator(String name, Long mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
	}

	public Integer getMediatorId() {
		return mediatorId;
	}

	public void setMediatorId(Integer mediatorId) {
		this.mediatorId = mediatorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
    
    
}
