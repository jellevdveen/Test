package nl.YCP.test;

import java.util.ArrayList;
import java.util.Collections;

public class Kaarten {
	int[][] team1Kaart;
	int[][] team2Kaart;
	ArrayList<Integer> ballenBak1;
	ArrayList<Integer> ballenBak2;
	
	public Kaarten() {
		team1Kaart = new int[5][5];
		team2Kaart = new int[5][5];
		ballenBak1 = new ArrayList<Integer>();
		ballenBak2 = new ArrayList<Integer>();
		
		vulKaart(team1Kaart, false);
		vulKaart(team2Kaart, true);
		
		vulBallenBak(ballenBak1, team1Kaart);
		vulBallenBak(ballenBak2, team2Kaart);
		
		while (trekBallen(7, ballenBak1, team1Kaart)) {
			vulKaart(team1Kaart, false);
			vulBallenBak(ballenBak1, team1Kaart);
		}
		
		while (trekBallen(7, ballenBak2, team2Kaart)) {
			vulKaart(team2Kaart, true);
			vulBallenBak(ballenBak2, team2Kaart);
		}
		
		gekleurdeBallen(ballenBak1, 3, true);
		gekleurdeBallen(ballenBak1, 3, false);
		gekleurdeBallen(ballenBak2, 3, true);
		gekleurdeBallen(ballenBak2, 3, false);
	}
	
	public void vulKaart(int[][] kaart, boolean parityEven){
		ArrayList<Integer> lijstVuller = new ArrayList<Integer>(25);
		int i = 10;
		while (lijstVuller.size() < 25) {
			if (parityEven) {
				lijstVuller.add(i);
			} else {
				lijstVuller.add(i+1);
			}
			i += 2;
		}
		Collections.shuffle(lijstVuller);
		
		for (i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++) {
				kaart[i][j] = lijstVuller.get(0);
				lijstVuller.remove(0);
			}
		}
	}
	
	public void vulBallenBak(ArrayList<Integer> ballenBak, int[][] kaart) {
		ballenBak.clear();
		for (int[] rij : kaart) {
			for (int i : rij) {
				ballenBak.add(i);
			}
		}
		Collections.shuffle(ballenBak);
	}
	
	public boolean trekBallen(int amount, ArrayList<Integer> bak, int[][] kaart) {
		for (int i = 0; i < amount; i++) {
			int gepakteBal = bak.get(0);
			bak.remove(0);
			if (amount == 2) {
				System.out.println("Bal nummer " + gepakteBal + " gepakt.");
			}
			for (int telRij = 0; telRij < 5; telRij++){
				for (int telKolom = 0; telKolom < 5; telKolom++) {
					if (kaart[telRij][telKolom] == gepakteBal) {
						kaart[telRij][telKolom] = 0;
					}
				}
			}
			
			for(int j = 0; j < 5; j++) {
				if (((kaart[0][j] + kaart[1][j] + kaart[2][j] + kaart[3][j] + kaart[4][j]) == 0) ||
					((kaart[j][0] + kaart[j][1] + kaart[j][2] + kaart[j][3] + kaart[j][4]) == 0) ||
					((kaart[0][0] + kaart[1][1] + kaart[2][2] + kaart[3][3] + kaart[4][4]) == 0) ||
					((kaart[0][4] + kaart[1][3] + kaart[2][2] + kaart[3][1] + kaart[4][0]) == 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void gekleurdeBallen(ArrayList<Integer> ballenBak, int amount, boolean kleurGroen) {
		for (int i = 0; i < amount; i++) {
			if (kleurGroen) {
				ballenBak.add(1);
			} else {
				ballenBak.add(0);
			}
		}
	}
	
	public ArrayList<Integer> getBallenBak(boolean team1) {
		if (team1) {
			return ballenBak1;
		} else {
			return ballenBak2;
		}
	}
	
	public int[][] getKaart(boolean team1) {
		if (team1) {
			return team1Kaart;
		} else {
			return team2Kaart;
		}
	}
	
	public void printKaart(boolean team1) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (team1) {
					if (team1Kaart[i][j] == 0) {
						System.out.print("XX");
					} else {
						System.out.print(team1Kaart[i][j]);
					}
				} else {
					if (team2Kaart[i][j] == 0) {
						System.out.print("XX");
					} else {
						System.out.print(team2Kaart[i][j]);
					}
				}
				if (j != 4) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
		}
	}
}
