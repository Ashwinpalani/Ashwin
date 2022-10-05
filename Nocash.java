package org.prog;

public class Nocash extends Exception {
public Nocash(int pins) throws Exception {
	System.out.println("*********Insufficient Balance**********");
	Atmmachine.Balance_enquiry(pins);
	System.out.println("***********Enter valid amount********");
	Atmmachine.withdraw(pins);
}
}
