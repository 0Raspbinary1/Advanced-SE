package main.java.play;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import main.java.alles.HandleInput;

public class Zahlenraten {

	int input_range_down;
	int input_range_up;
	
	int range_lowest;
	int range_highest;
		
	int[] range;
	
	int versuche;

//	----------------------^-Attribute-^------------------------------------
	
	public Zahlenraten(String[] args) {

		System.out.println("\nWillkommen beim Zahlenraten!\n");
		
		this.range = getRangeInput();
		
		createRandomNumber(this.range[0], this.range[1], args);


	}
//	---------------------^-Konstruktor-^-----------------------------------

	public int[] getRangeInput() {
		
		System.out.println("Gib dein Zahlenraum an:\n");
		Scanner sc = new Scanner(System.in);

		this.input_range_down = 0;
		this.input_range_up = 0;

		System.out.println("Minimum Zahl: ");
		do {
			
			input_range_down = sc.nextInt();

			if (input_range_down < 0) {
				System.out.println("Die Zahl darf nicht kleiner 0 sein!\n" + "Noch mal eingeben:");
			}
			
		} while (input_range_down < 0);
		

		System.out.println("Maximum Zahl: ");
		do {
			input_range_up = sc.nextInt();


			if (input_range_up >= Integer.MAX_VALUE) {
				System.out.println(
						"Die Zahl darf nicht groesser " + Integer.MAX_VALUE + " sein!\n" + "Noch mal eingeben:");
			}
		} while (input_range_up < 0);

		
		return new int[] { input_range_down, input_range_up };
	}
	

	public int createRandomNumber(int min, int max, String[] args) {
		
		System.out.println("Die Zufallszahl wird erzeugt\n");

		int randInt = min + (int) (Math.random() * ((max - min) + 1));
		
		System.out.println("Die Zufallszahl liegt zwischen " + min + " und " + max);
		
		System.out.println(guessTheNumber(min, max, randInt, args));
		
		System.out.println("Die Zufallszahl " + randInt + " wurde im " + this.versuche + ". Versuch erraten!");
		
		SpieleMain.main(args);
		
		return randInt;

	}
	
	public String guessTheNumber(int min, int max, int randInt, String[] args) {
		
		int eingabe;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			this.versuche++;
			
			System.out.println("Bitte geben Sie eine Zahl ein: ");
			
			eingabe = sc.nextInt();

			if (eingabe < min || eingabe > max) {
				System.out.println("Ungueltige Eingabe! Eingabe wiederholen!");

			} else if (eingabe < randInt) {
				System.out.println("Die gesuchte Zahl ist groesser!");
				versuche++;

			} else if (eingabe > randInt) {
				System.out.println("Die gesuchte Zahl ist kleiner!");
				versuche++;

			} else {
				return "Du hast die gesuchte Zahl gefunden!"; 
						
			}

		}
		
	}

}
