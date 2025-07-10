package com.it.pojo;

import lombok.Data;


public class Student {
	
	public Student() {
		
	}
	
    private Integer sId;
    
    private String sName;
	
	private String sEmail;
	
	private String sPassword ;
	
	private Long sPhoneNumber;
	
	private String sCourse;
	
	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public Long getsPhoneNumber() {
		return sPhoneNumber;
	}

	public void setsPhoneNumber(Long sPhoneNumber) {
		this.sPhoneNumber = sPhoneNumber;
	}

	public String getsCourse() {
		return sCourse;
	}

	public void setsCourse(String sCourse) {
		this.sCourse = sCourse;
	}

	

}
