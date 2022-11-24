package com.example.demo.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.StudentService;
import com.example.demo.util.CsvFileGenerator;

@Controller("/api")
public class ClgStudController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CsvFileGenerator csv;
	
	
	@GetMapping("/export-to-csv")
	  public void exportIntocsv(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment;filename=\"student.csv\"");

		csv.writeStudentToCsv(studentService.getAll(), response.getWriter());
		
		
	}

}
