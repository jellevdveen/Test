package nl.YCP.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BallenBak {
	protected ArrayList<Integer> ballenInBak;
	
	public BallenBak() {
		ballenInBak = new ArrayList<Integer>(36);
	}
	
	public BallenBak(ArrayList<Integer> ballenBakLijst) {
		ballenInBak = new ArrayList<Integer>(24);
		vulBallenBak(ballenBakLijst, 3);
	}
	
	
	public void vulBallenBak(ArrayList<Integer> ballenBakLijst, int aantalGroene) {
		for (Integer bal : ballenBakLijst) {	
			if (bal != 0) {
				ballenInBak.add(bal);
			}
		}
		for (int i = 0; i < 3; i++) {
			ballenInBak.add(0);
			if (i < aantalGroene) {
				ballenInBak.add(1);
			}
		}
		ballenInBak.add(2);
		
		Collections.shuffle(ballenInBak);
	}
	
	public void leegBallenBak() {
		ballenInBak.clear();
	}
	
	public int trekBal(Scanner s) {
		int bal = ballenInBak.remove(0);
		if (bal == 2) {
			System.out.println("Het vraagteken, welk getal mag ik voor jullie wegstrepen?");
			try {
				bal = Integer.valueOf(s.next());
			} catch (NumberFormatException NFE) {
				System.out.println("Dat is geen geldig getal!");
			}
		}
		return bal;
	}
	
	public void addBallen(int aantal, int soort) {
		for (int i = 0; i < aantal; i++) {
			ballenInBak.add(soort);
		}
		Collections.shuffle(ballenInBak);
	}
}
