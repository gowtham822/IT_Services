package com.it.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.TutorEntity;
import com.it.pojo.Tutor;
import com.it.repository.TutorRepo;

@Service
public class ServiceImp implements Services{

	@Autowired
	private TutorRepo tutorRepo;
		
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

}
