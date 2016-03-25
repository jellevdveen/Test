package nl.YCP.test2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;
import nl.YCP.test.LambdaTest;
import nl.YCP.test.VageTest;

public class test {

	static public void probeer(ArrayList<Integer> list, Integer i, LambdaTest<ArrayList<Integer>, Integer> T) {
		System.out.println(T.test(list, i));
	}

	
	public static void main(String[] args) {

		ArrayList<Integer> lijst = new ArrayList<Integer>();
		lijst.add(3);
		lijst.add(45);
		lijst.add(5);

		probeer(lijst, 100, new VageTest());
	}
}
