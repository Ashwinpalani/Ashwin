package org.prog;

public class MinAmout extends Exception {
public MinAmout(int pins) throws Exception {
	System.out.println("***********Invalid Entry*************");
	System.out.println("******************Enter amount multiples of 500 only**************");
	Atmmachine.withdraw(pins);
}
}
