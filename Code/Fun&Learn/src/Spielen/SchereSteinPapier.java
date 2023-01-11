package Spielen;

import java.util.Scanner;


public class SchereSteinPapier {

	public static void main(String[] args) {

		System.out.println("Willkommen bei Schere Stein Papier!\n"
				+ "Wir spielen Best-Of-Three, viel Glück!\n");
		for(int i = 0; i < 20;i++) {
			start();
		}
	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		String userInput;
		boolean aktiv = true;
		String[] arr = new String[]{"schere","stein","papier"};
		int generalWinCounter;

		while (aktiv) {
			generalWinCounter = 0;
			int pcPoints = 0;
			int userPoints = 0;
			int counterRounds = 0;
			while( generalWinCounter != 3) {
				counterRounds++;
				String randChoice = "";
				int rand = 0 + (int)(Math.random() * ((2 - 0) + 1));
				randChoice = arr[rand];
				System.out.println("" + counterRounds + ". Runde: Computer hat sich entschieden.\n"
						+ "Was nimmst du? Eingabe in Kleinbuchstaben:\n");
				userInput = sc.next();
				int erg = compare(randChoice, userInput);
				if(erg != 1) {
					generalWinCounter++;
				}
				if(erg == 0) {
					pcPoints++;
				}
				if(erg == 2) {
					userPoints++;
				}
			}
			if(userPoints > pcPoints) {
				System.out.println("Glückwunsch zum Sieg!");
			} else {
				System.out.println("Schade, vielleicht beim nächsten Spiel!");
			}
			System.out.println("willst du noch mal spielen?\n"
					+ "0: nein\n"
					+ "1: ja");
			int inputPlayingAgain = sc.nextInt();
			if(inputPlayingAgain == 0) {
				aktiv = false;
				//TODO Spielemenu
			}
		}
	}
	
	public static int compare(String randChoice, String userInput) {
		/*
		 * 0 = lose
		 * 1 = draw
		 * 2 = win
		 */
		if(randChoice.equals(userInput)) {
			System.out.println("unentschieden\n");
			return 1;
		}
		if(randChoice.equals("schere")) {
			if(userInput.equals("stein")) {
				System.out.println("gewonnen\n");
				return 2;
			}
			if(userInput.equals("papier")) {
				System.out.println("verloren\n");
				return 0;
			}
		}
		if(randChoice.equals("stein")) {
			if(userInput.equals("schere")) {
				System.out.println("verloren\n");
				return 0;
			}
			if(userInput.equals("papier")) {
				System.out.println("gewonnen\n");
				return 2;
			}
		}
		if(randChoice.equals("papier")) {
			if(userInput.equals("schere")) {
				System.out.println("gewonnen\n");
				return 2;
			}
			if(userInput.equals("stein")) {
				System.out.println("verloren\n");
				return 0;
			}
		}
		return 42;
	}
}