package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.ClgStudent;

public interface StudentService {
	
	void addStudent(ClgStudent student);
	
	List<ClgStudent> getAll();

}
