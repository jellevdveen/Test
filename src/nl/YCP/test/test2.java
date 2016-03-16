package nl.YCP.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test2 {

	public static int[][] getFromFile(String filename) {
		int[][] numbers;
		try {
			Scanner s = new Scanner(new File(filename));
			ArrayList<String[]> stringNumbers = new ArrayList<>(0);
			while (s.hasNext()) {
				
				for (int i = 0; i <= stringNumbers.size(); i++){
					String[] b = new String[stringNumbers.size() + 1];
					b[i] = s.next();
					System.out.println(b[i]);
					if (i == stringNumbers.size()) {
						stringNumbers.add(b);
						break;
					}
						
				}
				
			}
			numbers = new int[stringNumbers.size()][];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = new int[stringNumbers.get(i).length];
				for (int j = 0; j < stringNumbers.get(i).length; j++) {
					numbers[i][j] = Integer.valueOf(stringNumbers.get(i)[j]);
				}
			}
			return numbers;
				
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			return new int[0][0];
		} 
	}
}
