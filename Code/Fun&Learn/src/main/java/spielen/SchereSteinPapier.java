package main.java.spielen;

import java.util.HashMap;
import java.util.Scanner;

import main.java.alles.HandleInput;

public class SchereSteinPapier {

	private static HashMap<String, String> gameMap = new HashMap<>();

	private static HashMap<String, String> playAgainMap = new HashMap<>();

	public static void main(String[] args) {
		setGameMap();
		setPlayAgainMap();
		System.out.println("Willkommen bei Schere Stein Papier!\n" + "Wir spielen Best-Of-Three, viel Glueck!\n");
//		for(int i = 0; i < 20;i++) {
		start(args);
//		}
	}

	public static void start(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput;
		boolean aktiv = true;
		String[] arr = new String[] { "schere", "stein", "papier" };
//		int generalWinCounter;

		while (aktiv) {
//			generalWinCounter = 0;
			int pcPoints = 0;
			int userPoints = 0;
			int counterRounds = 0;
			while (pcPoints < 2 && userPoints < 2) {
				counterRounds++;
				String randChoice = "";
				int rand = 0 + (int) (Math.random() * ((2 - 0) + 1));
				randChoice = arr[rand];
				System.out.println("" + counterRounds + ". Runde: Computer hat sich entschieden.\n"
						+ "Was nimmst du? Eingabe in Kleinbuchstaben:\n");

				userInput = HandleInput.getInput(gameMap, System.in);

				System.out.println("user: " + userInput + "\n" + "Computer: " + randChoice);
				int erg = compare(randChoice, userInput);
				if (erg == 0) {
					pcPoints++;
				}
				if (erg == 2) {
					userPoints++;
				}
				if (erg == 1) {
				}
			}
			
			if (userPoints > pcPoints) {
				System.out.println("Glueckwunsch zum Sieg!");
			} else {
				System.out.println("Schade, vielleicht beim naechsten Spiel!");
			}
			System.out.println("Willst du noch mal spielen?\n" + "0: nein\n" + "1: ja");

			String inputPlayAgain = HandleInput.getInput(playAgainMap, System.in);
			if (inputPlayAgain.equals("nein")) {
				aktiv = false;
				SpieleMain.main(args);
			}
			if (inputPlayAgain.equals("ja")) {
				aktiv = true;
			}
			System.out.println();
		}
	}

	public static int compare(String randChoice, String userInput) {
		/*
		 * 0 = lose 1 = draw 2 = win
		 */
		if (randChoice.equals(userInput)) {
			System.out.println("unentschieden\n");
			return 1;
		}
		if (randChoice.equals("schere")) {
			if (userInput.equals("stein")) {
				System.out.println("gewonnen gegen Schere\n");
				return 2;
			}
			if (userInput.equals("papier")) {
				System.out.println("verloren gegen Schere\n");
				return 0;
			}
		}
		if (randChoice.equals("stein")) {
			if (userInput.equals("schere")) {
				System.out.println("verloren gegen Stein\n");
				return 0;
			}
			if (userInput.equals("papier")) {
				System.out.println("gewonnen gegen Stein\n");
				return 2;
			}
		}
		if (randChoice.equals("papier")) {
			if (userInput.equals("schere")) {
				System.out.println("gewonnen gegen Papier\n");
				return 2;
			}
			if (userInput.equals("stein")) {
				System.out.println("verloren gegen Papier\n");
				return 0;
			}
		}
		return 42;
	}

	private static void setGameMap() {
		gameMap.put("SCHERE", "Schere");
		gameMap.put("STEIN", "Stein");
		gameMap.put("PAPIER", "Papier");
	}

	private static void setPlayAgainMap() {
		playAgainMap.put("0", "nein");
		playAgainMap.put("1", "ja");
	}
}