package com.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TUTOR")
@Data
public class TutorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tId;
	
	private String tName;
	
	private String tEmail;
	
	private String tPassword ;
	
	private Long tPhoneNumber;
	
	private String tCourse;

}
