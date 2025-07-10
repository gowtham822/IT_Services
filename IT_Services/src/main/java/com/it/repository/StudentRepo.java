package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity , Integer> {
	
	public StudentEntity findBysEmail(String email);

}
