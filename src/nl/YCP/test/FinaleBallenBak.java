package nl.YCP.test;

import java.util.Collections;

public class FinaleBallenBak extends BallenBak {
	
	public FinaleBallenBak(boolean even) {
		vulBallenBak(even);
	}
	
	public void vulBallenBak(boolean even) {
		for (int i = 2; i <= 70; i +=2) {
			if (even) {
				this.ballenInBak.add(i);
			} else {
				this.ballenInBak.add(i-1);
			}
		}
		ballenInBak.add(-1);
		Collections.shuffle(ballenInBak);
	}

	public int trekFinaleBal() {
		int bal = ballenInBak.remove(0);
		return bal;
	}
}
