package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.it.entity.TutorEntity;
import com.it.pojo.Tutor;
import com.it.services.Services;

@RestController
public class TutorController {
	
	@Autowired
	private Services service;
	
	@PostMapping(value = "/itservices" , consumes = "application/json",produces = "text/plain")
	public ResponseEntity<String> signUp(@RequestBody Tutor tutor){
		
		String email = tutor.gettEmail();
		
		System.out.println(email);
		
		TutorEntity t = service.checkEmail(email);
		
		if(t != null) {
			
			service.saveTutor(tutor);
			
			return ResponseEntity.ok("Tutor registered successfully");
        }
		
		else
			return ResponseEntity.ok("Invalid SignUp");
		
	}

}
