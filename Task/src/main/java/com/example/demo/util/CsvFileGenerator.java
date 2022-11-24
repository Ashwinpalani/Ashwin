package com.example.demo.util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.example.demo.model.ClgStudent;

@Component
public class CsvFileGenerator {
	
	public void writeStudentToCsv(List<ClgStudent> students,Writer writer)
	{
		try {
			CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
			for(ClgStudent students1: students ) {
				printer.printRecord(students1.getId(),students1.getStudentName(),students1.getEmail(),students1.getMobileNo());
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

}
