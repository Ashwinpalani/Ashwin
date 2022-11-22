package com.Ashwin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Cab {

	
	static String shifts = null;
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat d2 = new SimpleDateFormat("hh:mm aa");
	static Date mrg,night;
	static Rider r = new Rider() ;
	static Reschedule s = new Reschedule();
    static Cab c = new Cab();
	static Services service = new Services();
    static BookingDetails b = new BookingDetails();
    static DbConnection dbes = new DbConnection();
	static int cb,bb;
	

	public static String shift() throws ParseException, InterruptedException {
		
		 System.out.println("Enter the Shift time:"); 
    	 String a = sc.nextLine();
    	 Date shiftTime = d2.parse(a);
         
		String b = "08:00 am";
		mrg = d2.parse(b);
		System.out.println(mrg);

		String c = "05:00 pm";
		night = d2.parse(c);
		System.out.println(night);

		if (shiftTime.before(mrg) || shiftTime.equals(mrg)) {
			
			 shifts = "Morning Shift";
			
		} else if (shiftTime.after(night) || shiftTime.equals(night)) {
			
		    shifts = "Night Shift";
			
		}
		return shifts;

	}




	public static String rescheduleShift(Date date4, Date rescheduledateto) throws ParseException, InterruptedException {
	
		String reShift= null;
		if (date4.before(mrg) || date4.equals(mrg)) {
			System.out.println("Your rescheduling process on " + d1.format(rescheduledateto)
					+ " for Morning shift was rescheduled successfully");
			
			 reShift = "Morning Shift";
			
			System.out.println("--------------------------------------------");
			
			Thread.sleep(1000);
			return reShift;
		

		} else if (date4.after(night) || date4.equals(night)) {

			System.out.println("Your rescheduling process on " + d1.format(rescheduledateto)
					+ " for night shift was rescheduled successfully");
			
		    reShift = "Night Shift";
		    
			System.out.println("--------------------------------------------");
			Thread.sleep(1000);
			
			return reShift;
			
		}
		return reShift;

	}

	public static double schedule(double travelDistances) throws ParseException, InterruptedException {

		LocalDate booking = LocalDate.now();
		Date bookedDate = d1.parse(booking.toString());
	   
		System.out.println("How many days did you want to book:");
		int day = sc.nextInt();
		LocalDate booked = LocalDate.now().plusDays(day);
		Date bookedFor = d1.parse(booked.toString());
		//r.setBookedFor(bookedFor);
		bb = service.cabs.element();
		cb = service.cabs.poll();
		System.out.println("Cab number:"+ cb);
		System.out.println("Available cabs:" + service.cabs);
		
		
		//System.out.println("Scheduled for upto " + r.getBookedFor() + " Totally for " + day + " days");
		r = new Rider(bookedDate,bookedFor,day,c.shifts);
		
		double spare = 101;
		System.out.println(
				"Do you want to reschedule or cancel the Schedule \n 1.Reschedule \n 2.CancelBooking \n 3.exit");
		int i = sc.nextInt();
		sc.nextLine();
		if (i == 1) {
			reschedule(bookedDate, bookedFor);
			dbes.schedule_Details(r,s);
		} else if (i == 2) {
			cancelBooking(bookedDate, bookedFor, day);
		} else { 
			spare = b.travelCost(travelDistances);
			System.out.println("TravelCost: " + spare);
			
			System.out.println("  --Thankyou for Booking-- \n ** HAVE A NICE DAY **");
			System.out.println("--------------------------------------------");
			Thread.sleep(1000);
			
		}
		return spare;
	}

	public static void reschedule(Date bookedDate, Date bookedFor) throws ParseException, InterruptedException {

		System.out.println("Enter the rescheduling date:");
		String a2 = sc.nextLine();
		Date rescheduleday = d1.parse(a2);
		Date rescheduledateto = null;
		String a1="";
		if ((rescheduleday.equals(bookedDate) || rescheduleday.after(bookedDate)) && rescheduleday.before(bookedFor)) {
			System.out.println("Enter from when do you want to reschedule:");
			a1 = sc.nextLine();
		    rescheduledateto = d1.parse(a1);
			
			if (rescheduledateto.before(rescheduleday) || rescheduledateto.equals(rescheduleday)) {
				System.out.println("*-*-*-Unable to reschedule*-*-*-*");
				reschedule(bookedDate, bookedFor);
			} else {
				
				System.out.println("Do you want to reschedule your shift time: \n 1.Yes \n 2.No");
				int s = sc.nextInt();
				sc.nextLine();
				if (s == 1) {
					System.out.println("Enter the Shift time:");
					String z = sc.nextLine();
					Date date4 = d2.parse(z);
					rescheduleShift(date4,rescheduledateto);
					
				} else {
					
					System.out.println("Your rescheduling process on " + d1.format(rescheduledateto)
							+ " was rescheduled successfully");
					
				}
			}
		}

		else {
			System.out.println("Your rescheduling date was not between the booked days");
			System.out.println("Please enter the valid reschedulingdate");
			reschedule(bookedDate, bookedFor);

		}
		rescheduledateto = d1.parse(a1);
		 s = new Reschedule(rescheduleday, rescheduledateto);
		System.out.println(s.getRescheduleDateTo());
		System.out.println(s.getRescheduleday());
	}


	public static void cancelBooking(Date bookedDate, Date bookedFor, int d) {
		service.cabs.add(c.bb);
		System.out.println(service.cabs);
		System.out.println("Booking details: \n *Date of Booking :" + r.getBookedDay() + " \n *Booked upto :"
				+ r.getBookedFor() + "\n Totally for " + d + " days booking has been cancelled");
		
	}

	

}
