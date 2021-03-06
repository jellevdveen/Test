package nl.YCP.test;

import java.util.Scanner;

public class Team {
	private Kaart teamKaart;
	private BallenBak teamBak;
	private int score;
	private boolean team1;
	private int groeneBallen;

	
	public Team (boolean team1) {
		this.team1 = team1;
		teamKaart = new Kaart(team1);
				
		if (this.team1) {
			System.out.println("Voor team 1 de even getallen!");
		} else {
			System.out.println("En voor team 2 hebben we de oneven getallen!");
		}
		
		System.out.println(teamKaart);
		
		Lingo.pause(2000);
		
		System.out.println(teamKaart.streepBeginWeg());
			
		teamBak = new BallenBak(teamKaart.getNumbers());
		
		Lingo.pause(2000);
	}
	
	
	
	public int addToScore(int i) {
		return (this.score += i);
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int pakBal(Scanner s) {
		int gepakteBal = teamBak.trekBal(s);
		switch (gepakteBal) {
		case 0		: 	System.out.println("Ach wat jammer, een rode bal!");
						System.out.println("Publiek \"Ahhhhhhhhhhh\"");
						Lingo.pause(1000);
						return 0;
		case 1		: 	System.out.println("Groene bal!!!");
						this.groeneBallen += 1;
						if (this.groeneBallen == 3) {
							System.out.println("Dat is de derde groene bal!!!\nJullie winnen de jackpot van 100 punten!");
							this.addToScore(100);
							this.groeneBallen = 0;
							teamBak.addBallen(1, 3);
						}
						return 1;
		default		:	System.out.println("Het is bal " + gepakteBal);
						teamKaart.streepWeg(gepakteBal);
		}
		System.out.println(teamKaart);
		
		if (teamKaart.checkLingo()) {
			lingoGemaakt();
			return 0;
		} else {
			return 2;
		}
	}
	
	private void lingoGemaakt() {
		System.out.println("En dat is Lingoooooo!!!!");
		System.out.println("***Publiek gaat wild tekeer!***");
		if (this.team1) {
			System.out.println("Honderd punten erbij voor team 1\n");
		} else {
			System.out.println("Honderd punten erbij voor team 2\n");
		}
		this.score += 100;
		
		Lingo.pause(2000);
		
		System.out.println("En we maken een nieuwe kaart!");
		System.out.println(teamKaart.nieuweKaart(team1));
		
		Lingo.pause(2000);
		
		System.out.println(teamKaart.streepBeginWeg());
		
		Lingo.pause(2000);
		
		System.out.println("We gooien de oude ballen eruit...");
		Lingo.pause(1000);
		System.out.println("...en de nieuwe erin! ");
		Lingo.pause(1000);
		
		teamBak.vulBallenBak(teamKaart.getNumbers(), (3 - this.groeneBallen));
	}

	@Override
	public String toString(){
		if (team1) {
			return "Team 1";
		} else {
			return "Team 2";
		}
	}

	public Kaart getKaart() {
		return teamKaart;
	}

	
	public void beginFinale() {
		System.out.println("We maken een nieuwe kaart!");
		teamKaart = new FinaleKaart(team1);
		System.out.println(getKaart());
		Lingo.pause(1000);
		teamKaart.streepBeginWeg();
		System.out.println(getKaart());
		Lingo.pause(1000);
		teamBak = new FinaleBallenBak(team1);
	}
	
	public int pakFinaleBal() {
		int gepakteBal = ((FinaleBallenBak)teamBak).trekFinaleBal();
		switch (gepakteBal) {
		case -1 :	System.out.println("De gouden bal!\nJullie hoeven deze ronde geen ballen meer te pakken");
					teamBak.addBallen(1, -1);
					return 0;
		default	:	System.out.println("Het is bal " + gepakteBal);
					teamKaart.streepWeg(gepakteBal);
					Lingo.pause(1000);
		}
		if (teamKaart.checkLingo()) {
			return 1;
		} else {
			return 2;
		}
	}
}
