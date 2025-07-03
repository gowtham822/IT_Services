package com.it.pojo;
import lombok.Data;

public class Tutor {
	
	public Tutor() {
		
	}
	
    private Integer tId;
    
    private String tName;
	
	private String tEmail;
	
	private String tPassword ;
	
	private Long tPhoneNumber;
	
	private String tCourse;
	
	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public Long gettPhoneNumber() {
		return tPhoneNumber;
	}

	public void settPhoneNumber(Long tPhoneNumber) {
		this.tPhoneNumber = tPhoneNumber;
	}

	public String gettCourse() {
		return tCourse;
	}

	public void settCourse(String tCourse) {
		this.tCourse = tCourse;
	}

	
}
