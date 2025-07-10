package com.it.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.StudentEntity;
import com.it.entity.TutorEntity;
import com.it.pojo.Student;
import com.it.pojo.Tutor;
import com.it.repository.StudentRepo;
import com.it.repository.TutorRepo;

@Service
public class ServiceImp implements Services{

	@Autowired
	private TutorRepo tutorRepo;
	
	@Autowired
	private StudentRepo studentRepo ;
		
	public TutorEntity checkEmail(String email) {
		
	   TutorEntity findByEmail = tutorRepo.findBytEmail(email);
		
		return findByEmail;
	}

	@Override
	public void saveTutor(Tutor tutor) {
		
		TutorEntity t = tutorRepo.findBytEmail(tutor.gettEmail());
		
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.typeMap(Tutor.class, TutorEntity.class)
		           .addMappings(mapper -> mapper.skip(TutorEntity::setTId)); // Skip ID

		modelMapper.map(tutor, t);
	
		tutorRepo.save(t);
		
	}

	@Override
	public boolean saveStudent(Student student) {
		
		StudentEntity s = studentRepo.findBysEmail(student.getsEmail());
		
		if(s==null) {
		
		StudentEntity st = new StudentEntity();
	
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.typeMap(Student.class, StudentEntity.class)
		           .addMappings(mapper -> mapper.skip(StudentEntity::setSId)); // Skip ID

		modelMapper.map(student,  st);
		
		studentRepo.save(st);
		
		return true;
		
		}
		
		else 
			
			return false;
		}

}
