package com.it.services;
import com.it.entity.TutorEntity;
import com.it.pojo.Student;
import com.it.pojo.Tutor;


public interface Services {
	
	public TutorEntity checkEmail(String email);
	
	public void saveTutor(Tutor tutor);
	
	public boolean saveStudent(Student student);
	

}
