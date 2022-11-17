package com.Ashwin;

import java.text.ParseException;
import java.util.Scanner;

public class CabBookingMain {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Services s = new Services();
		int mainMenuChoice;
		System.out.println("\n\nWelcome to AK Cab Booking System");
		do {
			System.out.println("\n\n1 - SignUp");
			System.out.println("2 - signIn");
			System.out.println("3 - Booking");
			System.out.println("4 - Exit\n\n");
			System.out.println("Enter Your Choice");
			mainMenuChoice = sc.nextInt();
			switch (mainMenuChoice) {
			case 1: {
				s.signUp();
				break;
			}
			case 2: {
				s.signIn();
				break;
			}
			case 3: {
				s.booking();
				break;
			}
			case 4: {
				   System.out.println("Thank You for using our service");
                   sc.close();
                   System.exit(0);
			}
			default:
				System.out.println("Enter Values only from 1 - 3");
                break;
			}
		} while (true);

	}
}
