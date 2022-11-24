package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClgStudentrepo;
import com.example.demo.model.ClgStudent;

@Service
public class ServiceImplementation implements StudentService{

	@Autowired
	ClgStudentrepo rep;
	
	@Override
	public void addStudent(ClgStudent student) {
		
		rep.save(student);
	}

	@Override
	public List<ClgStudent> getAll() {
		
		List<ClgStudent> clg = rep.findAll();
		
		return clg;
	}
	
	

}
