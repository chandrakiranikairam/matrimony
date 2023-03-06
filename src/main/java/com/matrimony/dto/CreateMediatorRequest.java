package com.matrimony.dto;

public class CreateMediatorRequest {

	private String name;
    private Long mobileNo;
    
	public CreateMediatorRequest() {
		super();
	}

	public CreateMediatorRequest(String name, Long mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
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
