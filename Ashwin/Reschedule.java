package com.Ashwin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reschedule {
	private Date rescheduleday;
	private Date rescheduleDateTo;
	SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
	
	Reschedule()
	{
		
	}

	Reschedule(Date rescheduleday , Date rescheduleDateTo){
	this.rescheduleday = rescheduleday;
	this.rescheduleDateTo = rescheduleDateTo;
}

	public Date getRescheduleday() {
		return rescheduleday;
	}

	public Date getRescheduleDateTo() {
		return rescheduleDateTo;

}
//	public void setRescheduleday(Date rescheduleday) {
//		this.rescheduleday = rescheduleday;
//	}
//	public void setRescheduleDateTo(Date rescheduleDateTo) {
//		this.rescheduleDateTo = rescheduleDateTo;
//	}
}
