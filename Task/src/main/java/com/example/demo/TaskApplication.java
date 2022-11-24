package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.StudentService;
import com.example.demo.model.ClgStudent;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {
	
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		for (int i = 0; i <= 10; i++) {

		      ClgStudent student = new ClgStudent();

		      student.setStudentName("Student Name");

		      student.setEmail("student@mail.com");

		      student.setMobileNo("XXXXXXXXXX");

		      studentService.addStudent(student);

		    }	
		
	}
	

}
