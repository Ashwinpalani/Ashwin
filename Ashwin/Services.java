package com.Ashwin;

import java.text.ParseException;
import java.util.*;

public class Services {
	static Scanner sc = new Scanner(System.in);
	static Cab c;
	static Map<String, Userdetails> data = new HashMap<>();
	static double maxDistance = 20;
	static Queue<Integer> cabs = new PriorityQueue<>(Arrays.asList(1,2,3,4,5,6,7,8));
	static DbConnection dbs = new DbConnection();
	static Userdetails u = new Userdetails();
//	static {
//		cabs.add(1);
//		cabs.add(2);
//		cabs.add(3);
//		cabs.add(4);
//		cabs.add(5);
//		cabs.add(6);
//		cabs.add(7);
//		cabs.add(8);
//	}

	public void signUp() throws Exception {
		System.out.println("\nEnter Details to Sign Up");
		System.out.println("Enter the Name:");
		String name = sc.next();
		System.out.println("Enter the Username:");
		String username = sc.next();
		System.out.println("Enter the password:");
		String password = sc.next();
		
		if (data.containsKey(username) == true) {
			System.out.println("User name already exists!");
			System.out.println("Try again\n\n\n");
			signUp();
		} else {
			data.put(username, new Userdetails(name, password, username));
			
			//System.err.println(data.get(u.getUsername()));
			u= data.get(username);
			//System.out.println(u.getUsername());
			String user = u.getUsername();
			dbs.signupDB(u);
		}
		System.out.println("Welcome to Ak cab booking system: " + name);
		System.out.println(data);
	}

	public void signIn() {
		//System.out.println(data.isEmpty());
		System.out.println("\nEnter Details to SignIn");
		System.out.println("Enter the Username:");
		String username = sc.next();
		System.out.println("Enter the password:");
		String password = sc.next();
		Userdetails c ;
		if (data.get(username) != null) {
			c = data.get(username);
			//System.out.println(c.getPassword());
			if (c.getUsername().equals(username) && (c.getPassword()).equals(password)) {
				System.out.println("Login Successfully");
				System.out.println("Hi " + c.getName());
			} else {
				System.out.println("Invalid username or password!");
				System.out.println("please try again");
				signIn();
			}
		} else {
			System.out.println("Invalid username or password!");
			System.out.println("please try again");
			signIn();
		}

	}

	public void booking() throws Exception {

		signIn();
		System.out.println("\n\nEnter your Location Latitude");
		Double sourceLatitude = sc.nextDouble();
		System.out.println("Enter your Location Longitude");
		Double sourceLongitude = sc.nextDouble();
		System.out.println("Enter Destiantion Latitude");
		Double destinationLatitude = sc.nextDouble();
		System.out.println("Enter Destiantion Longitude");
		Double destinationLongitude = sc.nextDouble();
		BookingDetails r = new BookingDetails(sourceLatitude, sourceLongitude, destinationLatitude,
				destinationLongitude);
		double travelDistances = r.distancekm(r);
		System.out.println("Total travel distance :" + travelDistances);
		if (travelDistances < maxDistance) {
			c.shift();
			double value = c.schedule(travelDistances);
			System.out.println(value);
			dbs.BookingDetails(r,u,value);		
		} else {
			System.out.println("Cab facility is not Available for your location");
		}
		

	}
}
