package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.pojo.JwtResponse;
import com.it.pojo.LoginRequest;
import com.it.pojo.Student;
import com.it.services.CustomUserDetailsService;
import com.it.services.Services;
import com.it.util.JwtUtil;

@RestController
public class StudentController {
	
	@Autowired
	private Services services;
	
	@Autowired
    private AuthenticationManager authManager;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@PostMapping("/ssignup")
	public ResponseEntity<String> signUp(@RequestBody Student student){
		
		boolean saveStudent = services.saveStudent(student);
		
		if(saveStudent)
			
			return ResponseEntity.ok("Registered Successfully");
		
		return ResponseEntity.ok("Student Already Exists");
		
	}
	
	@PostMapping("/slogin")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		
		System.out.println("Login endpoint hit");

		
		try {
			
			 Authentication authentication = authManager.authenticate
					                                     (new UsernamePasswordAuthenticationToken
					                                     (request.getEmail(), request.getPassword()));
			
		    }catch (Exception e) {
	            
		    	e.printStackTrace(); 
	            
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Invalid email or password");
		}
		
		   final  UserDetails user= userDetailsService.loadUserByUsername(request.getEmail());
		    
		   final String jwttoken = jwtUtil.generateToken(user);
		    	
		   return ResponseEntity.ok(new JwtResponse(jwttoken, request.getEmail()));
	}

}
