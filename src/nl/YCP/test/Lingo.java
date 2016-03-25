package nl.YCP.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lingo {
	private static final int AANTAL_WOORDEN = 1;
	private static final int AANTAL_KEER_RADEN = 5;
	private static ArrayList<String> woordenLijst = new ArrayList<String>();
	private static Team actieveTeam;
	private static int finaleCounter;
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = null;
		try {
			scanner2 = new Scanner(new File("Lingo.txt"));
			while (scanner2.hasNext()) {
				Lingo.woordenLijst.add(scanner2.next());
			}
			scanner2.close();
		} catch (FileNotFoundException FNFE) {
			System.out.println("Bronbestand niet gevonden!");
			return;
		} finally {
			scanner2.close();
		}
		
		
		
		System.out.println("Het is weer tijd voor Lingo!\nMet zoals gewoonlijk Mister Lingo... Francois Boulange\n");
		Lingo.pause(3000);
		
		Team team1 = new Team(true);
		Team team2 = new Team(false);
		
		Lingo.actieveTeam = team1;

		
		
		for (int i = 0; i < AANTAL_WOORDEN; i++) {
			Collections.shuffle(woordenLijst);
			Lingo.pause(1000);
			System.out.println("\n" + Lingo.actieveTeam + " is aan de beurt!\n");
			
			boolean geraden = speelLingo(woordenLijst.remove(0), scanner, team1, team2);
		
			if (geraden) {
				System.out.println("Dat is goed!!\n" + Lingo.actieveTeam + " krijgt er 25 punten bij!\n\n");
				Lingo.actieveTeam.addToScore(25);
				Lingo.pause(1500);
				System.out.println(Lingo.actieveTeam.getKaart());
				for (int bal = 0; bal < 2; bal++) {
					System.out.println(Lingo.actieveTeam + ", jullie mogen nog " + (2-bal) + " ballen pakken!");
					System.out.println("PUBLIEK: \"Groen! Groen! Groen!\"");
					Lingo.pause(500);
					System.out.println("Voer iets in om een bal te pakken");
					while (!scanner.hasNext()) {}
					scanner.next();
					int scenario = Lingo.actieveTeam.pakBal(scanner);
					switch (scenario) {
					case 0	:	System.out.println("De beurt gaat naar het andere team");
								if (Lingo.actieveTeam == team1) {
									Lingo.actieveTeam = team2;
								} else {
									Lingo.actieveTeam = team1;
								}
								bal = 2;
								break;
					case 1	:	System.out.println("Jullie mogen nog een extra bal pakken!");
								bal--;
								break;
					}
					Lingo.pause(2000);
				}
			} 
			
			System.out.println("De score is nu team 1: " + team1.getScore() + " punten");
			System.out.println("               team 2: " + team2.getScore() + " punten");
			
			Lingo.pause(2000);
			
			if ((i == AANTAL_WOORDEN - 1) && (team1.getScore() == team2.getScore())) {
				i--;
			}
		}
				
		System.out.println("Het spel is afgelopen,");
		if (team1.getScore() > team2.getScore()) {
			actieveTeam = team1;
		} else {
			actieveTeam = team2;
		}
		System.out.println(actieveTeam + " heeft gewonnen met " + team1.getScore() + " punten.\n\nWe zien jullie terug in de Finale.\n\n***Podium draait om***\n\n");
		Lingo.pause(2000);
		
		finale(actieveTeam, scanner);
		
		scanner.close();
	}
	

	
	
	private static boolean speelLingo(String inputWoord, Scanner scanner, Team team1, Team team2) {
		inputWoord = inputWoord.toLowerCase();
		

		if (speelRonde(scanner, inputWoord)) {
			return true;
		}
		
		if (Lingo.actieveTeam == team1) {
			Lingo.actieveTeam = team2;
		} else {
			Lingo.actieveTeam = team1;
		}
		
		System.out.println("Helaas, niet geraden.\n" + Lingo.actieveTeam + " mag nog 1 keer raden");
		
		String geradenWoord = scanner.next().toLowerCase();

		if (geradenWoord.equals(inputWoord)) {
			return true;
		} else if (geradenWoord.length() != inputWoord.length()) {
			System.out.println("Geen " + inputWoord.length() + "-letterig woord");
		}  else if (!testWoord(geradenWoord)) {
			System.out.println("Woord bevat ongeldige karakters");
		} else {
			char[] testWord = (evaluateWord(inputWoord, geradenWoord)).toCharArray();
			for (int j = 0; j < inputWoord.length(); j++) {
				System.out.print(testWord[j]);
				if (j == (inputWoord.length() - 1)) {
					System.out.println();
				}
				Lingo.pause(500);
			}
		}
		System.out.println("Helaas, ook niet geraden.\nHet woord was " + inputWoord.toUpperCase());
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

	public static void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException IE) {
			System.out.println("AAAAA.... Error!!");					
		}
	}

	public static void finale(Team actieveTeam, Scanner scanner) {
		actieveTeam.beginFinale();
		for (int i = 0; i < 5; i++) {
			String inputWoord = woordenLijst.remove(0);
			if (!speelRonde(scanner, inputWoord)) {
				finaleCounter = 6;
				System.out.println("Helaas, ook niet geraden.\nHet woord was " + inputWoord.toUpperCase());
			} else {
				System.out.println("Dat is goed!");
			}
			
			System.out.println(actieveTeam.getKaart());
			
			outer:
			for (int j = 0; j < finaleCounter; j++) {
				System.out.println("Jullie moeten nog " + (finaleCounter - j) + " ballen pakken!");
				Lingo.pause(1000);
				
				System.out.println("Voer iets in om een bal te pakken");
				while (!scanner.hasNext()) {}
				scanner.next();
				
				int result = actieveTeam.pakFinaleBal();
				System.out.println(actieveTeam.getKaart());
				
				switch (result) {
				case 0	:	break outer;
				case 1	:	System.out.println("Helaas, Lingo.... Jullie mogen de volgende keer terugkomen.");
							try {
								Scanner s = new Scanner(new File("LingoScores.txt"));
								String[] highscore = s.nextLine().split("-");
								s.close();
								System.out.println("Highscore is " + highscore[0] + " punten van " + highscore[1]);
							} catch (FileNotFoundException FNFE) {
								System.out.println("Highscore-lijst niet gevonden!");
							}
							
							return;
				case 2	:	continue;
				}
			}
			if (i != 4) {
				System.out.println("Jullie prijs staat nu op " + actieveTeam.addToScore(actieveTeam.getScore()) + " punten.");
				System.out.println("Jullie kunnen stoppen of doorgaan voor " + (actieveTeam.getScore() * 2) + " punten");
				System.out.println("Voer D in om door te gaan");
				if (!scanner.next().equalsIgnoreCase("d")) {
					System.out.println("Jullie gaan naar huis met " + actieveTeam.getScore() + " punten!");
					String[] highscore = new String[2];
					try {
						Scanner s = new Scanner(new File("LingoScores.txt"));
						highscore = s.nextLine().split("-");
						s.close();
						if (actieveTeam.getScore() > Integer.valueOf(highscore[1])) {
							try{ 
								PrintWriter writer = new PrintWriter("LingoScores", "UTF-8");
								System.out.println("Highscore!, voer je naam in!");
								writer.println(scanner.next() + "-" + actieveTeam.getScore());
								writer.close();
							} catch (UnsupportedEncodingException UCE) {
								System.out.println("Onbekende Error!");
							}
							
						} else {
							System.out.println("Highscore is " + highscore[1] + " punten van " + highscore[0]);
						}
					} catch (FileNotFoundException FNFE) {
						System.out.println("Highscore-lijst niet gevonden!");
					}
					
					
					
					
					return;
				}
			} else {
				System.out.println("Jullie hebben gewonnen en gaan naar huis met " + actieveTeam.addToScore(actieveTeam.getScore()));
			}
		}
		
		
		
	}
	
	public static boolean speelRonde(Scanner scanner, String inputWoord) {
		finaleCounter = 0;
		for (int i = 0; i < AANTAL_KEER_RADEN; i++) {
			finaleCounter++;
			System.out.println(Lingo.actieveTeam + ", Raad een woord:");
			
			
			String geradenWoord = scanner.next().toLowerCase();

			if (geradenWoord.equals(inputWoord)) {
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
					Lingo.pause(500);
				}
			}
		}
		return false;
	}
}
