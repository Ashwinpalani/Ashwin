package org.prog;

public class PinNotFoundException extends Exception {
public PinNotFoundException() throws Exception {
	System.out.println("Pin not found");
	System.out.println("**********Enter Valid pin*********");
	Atmmachine.entryPin();
}
}
