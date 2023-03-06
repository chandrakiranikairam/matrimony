package com.matrimony.dto;

public class EditMediatorRequest {

	private Integer mediatorId;
	private String name;
    private Long mobileNo;
	public EditMediatorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EditMediatorRequest(Integer mediatorId, String name, Long mobileNo) {
		super();
		this.mediatorId = mediatorId;
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
