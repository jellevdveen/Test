package nl.YCP.test;

import java.util.Scanner;

public class Test {
	static class Rijtuig {
		
		public void printNaam() {
			System.out.println("Ik ben een rijtuig");
		}
	}
	
	static class Fiets extends Rijtuig {
		
		@Override
		public void printNaam() {
			System.out.println("Ik ben een fiets");
		}
		
		public void bel() {
			System.out.println("Tring");
		}
	}
	
	
	public static void main(String[] args) {
		
		
		
		Rijtuig r = new Fiets();
		
		r.printNaam();
		//r.bel();
		((Fiets)r).bel();
		System.out.println("");
		
		
		DierenWinkel v = new Vogelspeciaalzaak();
		
		v.print(true);
		v.print(false);
		
		System.out.println("");
		
		DierenWinkel w = new DierenWinkel();
		
		w.print(true);
		w.print(false);
		
	}
	
	static class Dier {
		private String naam;
		public Dier(String n) {naam = n;}
		
		@Override
		public String toString() {
			return this.naam;
		}
	}
	
	static class Vogel extends Dier {
		public Vogel(String n) {super(n);}
	}
	
	static class Vis extends Dier {
		public Vis(String n) {super(n);}
	}
	
	static class DierenWinkel {
		protected Dier[] DierenVoorraad;
		
		public DierenWinkel() {
			DierenVoorraad = new Dier[3];
			DierenVoorraad[0] = new Dier("Hond");
			DierenVoorraad[1] = new Vis("Makreel");
			DierenVoorraad[2] = new Vogel("Papegaai");
		}
		
		
		public Dier[] getVoorraad() {
			return getTotaleVoorraad();
		}
		
		public Dier[] getTotaleVoorraad() {
			return DierenVoorraad;
		}
		
		public void print(boolean specialiteit) {
			for (int i = 0; i < getVoorraad().length; i++) {
				if (specialiteit) {
					if (getVoorraad()[i] != null) {
						System.out.println(getVoorraad()[i]);
					}
				} else {
					if (getTotaleVoorraad()[i] != null) {
						System.out.println(getTotaleVoorraad()[i]);
					}
				}
				
				
			}
			System.out.println("");	
		}	
	}
	
	static class Vogelspeciaalzaak extends DierenWinkel {
		
		
		public Vogelspeciaalzaak() {
			DierenVoorraad = new Dier[3];
			DierenVoorraad[0] = new Vogel("Papegaai");
			DierenVoorraad[1] = new Vogel("Penguin");
			DierenVoorraad[2] = new Vis("Clownvis");
		}
		
		@Override
		public Vogel[] getVoorraad() {
			Vogel[] VogelVoorraad = new Vogel[DierenVoorraad.length];
			int i = 0;
			for (Dier d : DierenVoorraad) {
				if (d instanceof Vogel) {
					VogelVoorraad[i] = (Vogel) d;
					i++;
				}
			}
			return VogelVoorraad;
		}
	}
}

