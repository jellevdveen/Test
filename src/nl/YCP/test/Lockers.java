package nl.YCP.test;



public class Lockers {

	public static void main(String[] args) {
		boolean[] lockers = new boolean[1500];
		
		for (int i = 1; i < 1501; i++) {
			lockers[(i-1)] = !lockers[(i-1)];
		}

	}

}
