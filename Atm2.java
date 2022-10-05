package org.prog;

import java.util.Scanner;

public class Atm2 extends Atmmachine {
	private void entrypin() {
		System.out.println("************Thank you**************");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("********************Welcome***********************");
		System.out.println("********************AK bank***********************");
		Scanner sc = new Scanner(System.in);
		try {
			entryPin();
		} 
		catch (Exception e) {
		
		}
		Atm2 s=new Atm2();
		s.entrypin();
	}

}
