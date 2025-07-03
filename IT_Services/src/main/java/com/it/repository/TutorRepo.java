package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.TutorEntity;

public interface TutorRepo extends JpaRepository<TutorEntity , Integer> {
	
	public TutorEntity findBytEmail(String email);
	
}
