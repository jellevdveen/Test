package nl.YCP.test;

import java.util.Scanner;

public class Test {
	static int askValue(String variable) {
		System.out.println("Enter " + variable + " please.");
		Scanner s = new Scanner(System.in);
		try {
			int value = Integer.valueOf(s.next());
			if (value > 0 && value < 11) {
				return value;
			} else {
				System.out.println("This is not a valid integer between 0 and 10");
				return 0;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("This is not a valid integer between 0 and 10");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int result = 0;
		int largest = 0;
		int number = 0;
		
		while (number == 0) 
			number = askValue("number of inputs");

				
		int[] values = new int[number];
			
			
		for (int i = 0; i < values.length;) {
			int j = askValue("input " + (i+1));
			if (j != 0)
				values[i++] = j;
			}
			
		for (int i : values) {
			if (i > 7)
			result++;
			if (i > largest)
			largest = i;
		}
	
		System.out.println(result + " of these numbers are larger than 7");
		System.out.println("The largest of the numbers you entered is " + largest);
	}
}

