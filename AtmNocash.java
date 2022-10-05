package org.prog;

public class AtmNocash extends Exception {
public AtmNocash(int pins) throws Exception {
	System.out.println("************Enter Money is not Available in Atm**********");
	System.out.println("Enter Money below "+Atmmachine.AtmMoney);
	Atmmachine.withdraw(pins);
}
	
}
