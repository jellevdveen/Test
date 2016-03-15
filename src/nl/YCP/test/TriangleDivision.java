package nl.YCP.test;

public class TriangleDivision {

	private static boolean divisionTest(int i, int divisors) {
		int counter = 0;
		for (int j = 1; j <= i; j++){
			if (i % j == 0)
				counter++;
		}
		if (counter >= divisors) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int triangle = 1;
		int number = 1;
		while (!divisionTest(triangle, 500)) {
			do {
				number++;
				triangle += number;
			} while (triangle % 420 != 0);
			System.out.println(number);
		}
		System.out.println("waarde is " + number + " " + triangle);
	}
}
