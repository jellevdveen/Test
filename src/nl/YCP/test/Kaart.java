package nl.YCP.test;

import java.util.ArrayList;
import java.util.Collections;



public class Kaart {
	protected int[][] actieveKaart;
	
	public Kaart(boolean even) {
		actieveKaart = new int[5][5];
		nieuweKaart(even);
	}
	
	
	
	
	public Kaart nieuweKaart (boolean even) {
		int toevoegGetal = 10;
		ArrayList<Integer> getallenOpKaart = new ArrayList<Integer>(25);
		if (!even) {
			toevoegGetal += 1;
		}
		
		while (getallenOpKaart.size() < 25) {
			getallenOpKaart.add(toevoegGetal);
			toevoegGetal += 2;
		}
		
		Collections.shuffle(getallenOpKaart);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				actieveKaart[i][j] = getallenOpKaart.remove(0);
			}
		}
		return this;
	}
	
	public Kaart streepBeginWeg () {
		System.out.println("En er worden er 8 weggestreept!");
		actieveKaart[0][4] = actieveKaart[1][0] = actieveKaart[1][2] = actieveKaart[2][3] 
				= actieveKaart[3][0] = actieveKaart[3][1] = actieveKaart[4][1] = actieveKaart[4][4] = 0;
		return this;
	}
	
	
	public void streepWeg(int getrokkenBal) {
		for (int[] row : actieveKaart) {
			for (int i = 0; i < 5; i++) {
				if (getrokkenBal == row[i]) {
					row[i] = 0;
					System.out.println("Deze wordt weggestreept!\n");
					return;
				}
			}
		}
		System.out.println("Staat niet op de kaart!");
	}
	
	public boolean checkLingo() {
		for(int j = 0; j < 5; j++) {
			if (((actieveKaart[0][j] + actieveKaart[1][j] + actieveKaart[2][j] + actieveKaart[3][j] + actieveKaart[4][j]) == 0) ||
				((actieveKaart[j][0] + actieveKaart[j][1] + actieveKaart[j][2] + actieveKaart[j][3] + actieveKaart[j][4]) == 0) ||
				((actieveKaart[0][0] + actieveKaart[1][1] + actieveKaart[2][2] + actieveKaart[3][3] + actieveKaart[4][4]) == 0) ||
				((actieveKaart[0][4] + actieveKaart[1][3] + actieveKaart[2][2] + actieveKaart[3][1] + actieveKaart[4][0]) == 0)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Integer> getNumbers() {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int[] row : actieveKaart) {
			for (int i : row) {
				if (i != 0) {
					tempList.add(i);
				}
			}
		}
		return tempList;
	}
	
	@Override
	public String toString() {
		StringBuilder tempString = new StringBuilder("");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (actieveKaart[i][j] == 0) {
					tempString.append("XX ");
				} else {
					tempString.append(actieveKaart[i][j] + " ");
				}
			}
			tempString.append("\n");
		}
		
		return tempString.toString();
		
	}
}
