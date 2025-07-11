package com.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "STUDENT")
@Data
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	
	private String sName;
	
	private String sEmail;
	
	private String sPassword ;
	
	private Long sPhoneNumber;
	
	private String sCourse;
	
	

}
