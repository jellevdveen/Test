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
						Lingo.pause(1000);
						return 0;
		case 1		: 	System.out.println("Groene bal!!!");
						this.groeneBallen += 1;
						if (this.groeneBallen == 3) {
							System.out.println("Dat is de derde groene bal!!!\nJullie winnen de jackpot van 0 euro!");
							this.groeneBallen = 0;
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
		if (this.team1) {
			System.out.println("Honderd punten erbij voor team 1");
		} else {
			System.out.println("Honderd punten erbij voor team 2");
		}
		this.score += 100;
		
		Lingo.pause(2000);
		
		System.out.println("En we maken een nieuwe kaart!");
		System.out.println(teamKaart.nieuweKaart(team1));
		
		Lingo.pause(2000);
		
		System.out.println(teamKaart.streepBeginWeg());
		
		Lingo.pause(2000);
		
		System.out.println("We gooien de oude ballen eruit...");
		Lingo.pause(5000);
		System.out.println("...en de nieuwe erin! ");
		
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
}
