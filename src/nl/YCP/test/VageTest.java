package nl.YCP.test;

import java.util.ArrayList;

public class VageTest implements LambdaTest<ArrayList<Integer>, Integer>{

	@Override
	public boolean test(ArrayList<Integer> t, Integer u) {
		for (int a = 0; a < t.size(); a++) {
			if (u < t.get(a)) {
				return false;
			}
		}
		return true;
	}
	
}
