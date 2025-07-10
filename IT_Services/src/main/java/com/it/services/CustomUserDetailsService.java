package com.it.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.it.entity.StudentEntity;
import com.it.entity.TutorEntity;
import com.it.repository.StudentRepo;
import com.it.repository.TutorRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	public TutorRepo tutorRepo ;
	
	@Autowired
	private StudentRepo studentRepo ;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		 TutorEntity tutor = tutorRepo.findBytEmail(email);
		 
		 StudentEntity student = studentRepo.findBysEmail(email);
		 
		 if (tutor != null) {
			 
			 return new User(tutor.getTEmail(), tutor.getTPassword(), new ArrayList<>());
			 
	        }
		 
		 if(student != null){
			 
			 return new User(student.getSEmail(), student.getSPassword(), new ArrayList<>());	
            
        }
		
		 if(student == null || tutor == null)
		
		 throw new UsernameNotFoundException("Student not found with email: " + email);
		 
		 return null;
			
	}

}
