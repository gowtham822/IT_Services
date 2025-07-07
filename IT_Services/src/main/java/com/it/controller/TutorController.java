package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.TutorEntity;
import com.it.pojo.JwtResponse;
import com.it.pojo.LoginRequest;
import com.it.pojo.Tutor;
import com.it.services.CustomUserDetailsService;
import com.it.services.Services;
import com.it.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class TutorController {
	
	@Autowired
	private Services service;
	
	@Autowired
    private AuthenticationManager authManager;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	 @Autowired
	 private CustomUserDetailsService userDetailsService;
	
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
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		
		System.out.println("Login endpoint hit");

		
		try {
			
			 Authentication authentication = authManager.authenticate(
		                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			
		    }catch (Exception e) {
	            
		    	e.printStackTrace(); // debug line
	            
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Invalid email or password");
		}
		
		    final  UserDetails user= userDetailsService.loadUserByUsername(request.getEmail());
		    
		    final String jwttoken = jwtUtil.generateToken(user);
		    	
		    return ResponseEntity.ok(new JwtResponse(jwttoken, request.getEmail()));
	}

}
