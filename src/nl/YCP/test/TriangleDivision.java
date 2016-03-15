package nl.YCP.test;

public class TriangleDivision {

	private static boolean divisionTest(int i) {
		int counter = 0;
		for (int j = 1; j <= i; j++){
			if (i % j == 0)
				counter++;
		}
		if (counter > 500) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int triangle = 0;
		int number = 0;
		while (!divisionTest(triangle)) {
			number++;
			triangle += number;
		}
	}
}
