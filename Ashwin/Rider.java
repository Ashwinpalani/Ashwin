package com.Ashwin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Rider {
	
	SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat d2 = new SimpleDateFormat("hh:mm aa");
	private String shift;
	private Date bookedDay;
	private Date bookedFor;
	private int day; 
	
	public Rider() {
	
	}
	
	Rider(Date bookedDay,Date bookedFor,int day,String shift)
	{
		this.shift = shift;
		this.bookedDay = bookedDay;
		this.bookedFor = bookedFor;
		this.day = day;
	}
	

	public String getShift() {
		return shift;
	}
	public String getBookedDay() {
		return d1.format(bookedDay);
	}
	public String getBookedFor() {
		return d1.format(bookedFor);
	}
	public int getDay() {
		return day;
	}

	public String updateQuery() {
		return "'"+shift+"','"+bookedDay+"','"+bookedFor+"','"+day+"";
		
}
	
	
	
	
}
