package org.prog;

import java.util.*;

public class Atmmachine {
	static Scanner sc = new Scanner(System.in);
	static int withdraw;
	static int AtmMoney = 10000;
	static Map<Integer, Integer> pin = new HashMap<>();

	static void Check_pin(int pins) throws Exception {
		if (pin.containsKey(pins)) {
			System.out.println("****************Menu****************");
			System.out.println("1.Cash Withdrawal\n2.Balance Enquiry\n3.Fast Cash");
			int service = sc.nextInt();
			switch (service) {
			case 1:
				withdraw(pins);
				break;
			case 2:
				Balance_enquiry(pins);
				break;
			case 3:
				fastCash(pins);
				break;
			default:
				System.out.println("Invalid number");
				System.out.println("Enter Again");
				Check_pin(pins);
				break;
			}
		} else {
			try {
				throw new PinNotFoundException();
			} catch (Exception e) {

			}

		}
	}

	static void withdraw(int pins) throws Exception {

		System.out.println("Enter the amount your want:");
		int amount = sc.nextInt();
		if (amount > AtmMoney) {
			throw new AtmNocash(pins);
		} else if (amount <= pin.get(pins)) {
			if (amount % 500 == 0) {
				System.out.println("Transaction is processing......");
				System.out.println("Take your cash");
				System.out.println("Do you want to check your balance \n1.yes\n2.No");
				int a = sc.nextInt();
				if (a == 1) {
					Main_Bal(amount, pin.get(pins));
				} else {
					System.out.println("Your Transaction is completed");
					System.out.println("****************Thank you******************");
				}

			} else {
				throw new MinAmout(pins);
			}
		} else {
			throw new Nocash(pins);
		}

	}

	static void Balance_enquiry(int pins) {

		System.out.println("Your Account balance : " + pin.get(pins));
	}

	static void Main_Bal(int withdraw, int amount) {

		System.out.println("Your Account balance: " + (amount - withdraw));
	}

	static void fastCash(int pins) {
		System.out.println("1.500\n2.1000\n3.2000\n4.5000");
		int i = sc.nextInt();
		int b[] = { 500, 1000, 2000, 5000 };
		int instantcash = b[i - 1];
		if (instantcash <= pin.get(pins)) {
			System.out.println("Transaction is processing......");
			System.out.println("Take your cash");
			System.out.println("Do you want to check your balance 1.yes\n2.No");
			int a = sc.nextInt();
			if (a == 1) {
				Main_Bal(instantcash, pin.get(pins));
			} else {
				System.out.println("Your Transaction is completed");
				System.out.println("****************Thank you******************");
			}

		} else {
			System.out.println("Insufficient Balance");
		}
	}

	static void entryPin() throws Exception {
		pin.put(2001, 12000);
		pin.put(2002, 17000);
		pin.put(2003, 1205);
		pin.put(2004, 4623);
		pin.put(2005, 1000);
		pin.put(2006, 1600);
		pin.put(2007, 12000);
		System.out.println("Please enter the Pin:");
		int pins = sc.nextInt();
		Check_pin(pins);
	}

}
