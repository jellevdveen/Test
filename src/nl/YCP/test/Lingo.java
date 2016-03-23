package nl.YCP.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lingo {
	private static final int MAX_WORDS = 10;
	private static final int AANTAL_KEER_RADEN = 5;
	private static ArrayList<String> woordenLijst = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int team1Score = 0;
		int team2Score = 0;
		boolean team1Turn = true;
		Lingo.woordenLijst.add("appel");
		Kaarten tweeKaarten = new Kaarten();
		
		System.out.println("Het is weer tijd voor Lingo!");
		
		System.out.println("\nTeam 1, voor jullie hebben we de oneven getallen:\n");
		tweeKaarten.printKaart(true);
		
		System.out.println("\nTeam 2, voor jullie hebben we de even getallen:\n");
		tweeKaarten.printKaart(false);
		
		
		for (int i = 0; i < MAX_WORDS; i++) {
			Collections.shuffle(woordenLijst);
			if (team1Turn) {
				System.out.println("\nTeam 1 is aan de beurt!\n");
			} else {
				System.out.println("\nTeam 2 is aan de beurt!\n");
			}
			boolean geraden = speelLingo(woordenLijst.get(0), team1Turn, scanner);
		
			if (geraden) {
				// pak 2 ballen
			} else {
				team1Turn = !team1Turn;
			}
			
			
			
			
			
			
			
		}
		scanner.close();
	}
	

	
	
	private static boolean speelLingo(String inputWoord, boolean team1, Scanner scanner) {
		inputWoord = inputWoord.toLowerCase();
		

		for (int i = 0; i < AANTAL_KEER_RADEN; i++) {
			if (team1) {
				System.out.println("Team 1, Raad een woord:");
			} else {
				System.out.println("Team 2, Raad een woord:");
			}
			
			String geradenWoord = scanner.next().toLowerCase();

			if (geradenWoord.equals(inputWoord)) {
				scanner.close();
				return true;
			} else if (geradenWoord.length() != inputWoord.length()) {
				System.out.println("Geen " + inputWoord.length() + "-letterig woord");
				continue;
			}  else if (!testWoord(geradenWoord)) {
				System.out.println("Woord bevat ongeldige karakters");
				continue;
			} else {
				char[] testWord = (evaluateWord(inputWoord, geradenWoord)).toCharArray();
				for (int j = 0; j < inputWoord.length(); j++) {
					System.out.print(testWord[j]);
					if (j == (inputWoord.length() - 1)) {
						System.out.println();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException IE) {
						System.out.println("AAAAA.... Error!!");					
					}
				}
			}
		}
		return false;
	}
	
	private static String evaluateWord(String inputWoord, String geradenWoord) {
		char[] iWoord = inputWoord.toCharArray();
		char[] gWoord = geradenWoord.toCharArray();
		char[] returnWoord = new char[inputWoord.length()];
		
		for (int i = 0; i < inputWoord.length(); i++) {
			returnWoord[i] = '.';
			if (iWoord[i] == gWoord[i]) {
				returnWoord[i] = 'x';
				iWoord[i] = '-';
				gWoord[i] = '_';		
			}
		}
		
		for (int i = 0; i < inputWoord.length(); i++) {
			for (int j = 0; j < inputWoord.length(); j++) {
				if (iWoord[i] == gWoord[j]) {
					returnWoord[j] = 'o';
					gWoord[j] = '_';
					iWoord[i] = '-';
				}
			}
		}
		return String.copyValueOf(returnWoord);
	}
	
	private static boolean testWoord(String Woord) {
		char[] test = Woord.toLowerCase().toCharArray();
		for (char c : test) {
			if(!((c >= 'a') && (c <= 'z'))) {
				return false;
			}
		}
		return true;	
	}
}
