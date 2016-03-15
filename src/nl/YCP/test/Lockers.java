package nl.YCP.test;



public class Lockers {

	public static void main(String[] args) {
		boolean[] lockers = new boolean[1500];
		int counter = 0;
		
		for (int i = 1; i < 1501; i++) {
			for (int j = 1; j < 1501; j++) {
				if (j % i == 0)
				lockers[(j-1)] = !lockers[(j-1)];
			}
			
		}
		
		for (boolean b : lockers) {
			if (b) {
				counter++;
			}
		}
		System.out.println(counter);
	}

}
