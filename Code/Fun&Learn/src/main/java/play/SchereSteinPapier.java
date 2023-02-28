package main.java.play;

import java.util.HashMap;
import java.util.Scanner;

import main.java.alles.HandleInput;

public class SchereSteinPapier {
	

	private HashMap<String, String> gameMap = new HashMap<>();
	
	public HashMap<String, String> getGameMap() {
		return gameMap;
	}

	private User computer = new Computer();
	private User person = new Person();

	public SchereSteinPapier() {
		setGameMap();
	}

	public String validateFinalResult(int user, int pc) {
		if (user > pc) {
			return "Glueckwunsch zum Sieg!";
		} else if (pc > user) {
			return "Schade, vielleicht beim naechsten Spiel!";
		}
		return "Fehler";
	}
	


	public void start(String[] args) {
		System.out.println("Willkommen bei Schere Stein Papier!\n" + "Wir spielen Best-Of-Three, viel Glueck!\n");
		String userInput;
		boolean aktiv = true;

		while (aktiv) {
			
			int pcPoints = 0;
			int userPoints = 0;
			int counterRounds = 0;
			
			while (this.computer.getUserPoints() < 2 && this.person.getUserPoints() < 2) {
				counterRounds++;
				String pcChoice = this.computer.getChoice();
				System.out.println("" + counterRounds + ". Runde: Computer hat sich entschieden.\n"
						+ "Was nimmst du? Eingabe in Kleinbuchstaben:\n");
				//auslagern
				//userInput = HandleInput.getInput(gameMap, System.in);
				userInput = this.person.getChoice();
				System.out.println("userinput: " + userInput + "\n------------");

				System.out.println("user: " + userInput + "\n" + "Computer: " + pcChoice + "\n------------");
				String erg = compare(pcChoice, userInput);
				
				switch (erg) {
				
					case "1": break;
					
					case "2": this.person.incrementUserPoints();;break;
					
					case "0": this.computer.incrementUserPoints();;break;
					
					default: throw new IllegalArgumentException("Unexpected value: " + erg);
				}
				
	
				System.out.println("pc: " + this.computer.getUserPoints() + "    " + "user: " + this.person.getUserPoints());
			}
			System.out.println(validateFinalResult(this.person.getUserPoints(), this.computer.getUserPoints()));

			SpieleMain.main(args);

		}
	}

	public String compare(String randChoice, String userInput) {
		/*
		 * 0 = lose 1 = draw 2 = win
		 */
		if (randChoice.equals(userInput)) {
			System.out.println("unentschieden\n");
			return "1";
		}
		switch(randChoice) {
		case "schere": 
			if (userInput.equals("stein")) {
				System.out.println("gewonnen gegen Schere\n");
				return "2";
			}
			if (userInput.equals("papier")) {
				System.out.println("verloren gegen Schere\n");
				return "0";
			}			
		case "stein":
			if (userInput.equals("schere")) {
				System.out.println("verloren gegen Stein\n");
				return "0";
			}
			if (userInput.equals("papier")) {
				System.out.println("gewonnen gegen Stein\n");
				return "2";
			}			
		case "papier":
			if (userInput.equals("schere")) {
				System.out.println("gewonnen gegen Papier\n");
				return "2";
			}
			if (userInput.equals("stein")) {
				System.out.println("verloren gegen Papier\n");
				return "0";
			}
		default: return "42";
		}

	}

	private void setGameMap() {
		gameMap.put("SCHERE", "schere");
		gameMap.put("STEIN", "stein");
		gameMap.put("PAPIER", "papier");
	}

}
