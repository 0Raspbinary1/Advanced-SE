package main.java.spielen;

import java.util.Scanner;

public class SpieleMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input_game = 0;

		System.out.println("\nHallo und herzlich Willkommen im Spiele-Modus!\n" + 
		"Was moechtest du spielen?\n" + 
		"1: Tik Tak Toe\n" + 
		"2: Schiffe versenken\n" + 
		"3: Zahlen raten\n" + 
		"4: Schere Stein Papier");

		input_game = sc.nextInt();

		if (input_game == 0) {

		}

		if (input_game == 1) {

		}

		if (input_game == 2) {

		}
		if (input_game == 3) {
			Zahlenraten.main(args);
		}
		if(input_game == 4) {
			SchereSteinPapier.main(args);
		}

	}

}
