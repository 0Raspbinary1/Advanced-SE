package main.java.play;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import main.java.alles.HandleInput;

public class Zahlenraten {

	int input_range_down;
	int input_range_up;

	int randInt;
	
	int eingabe;
	
	int versuche = 0;

	public Zahlenraten() {

		System.out.println("\nWillkommen beim Zahlenraten!\n");

	}

	public void perform(String[] args) {
		getRangeInput();

		this.randInt = createRandomNumber(this.input_range_down, this.input_range_up);

		System.out.println("Die Zufallszahl liegt zwischen " + this.input_range_down + " und " + this.input_range_up);

		guessIt();

		System.out.println("Die Zufallszahl " + randInt + " wurde im " + this.versuche + ". Versuch erraten!");

		SpieleMain.main(args);
	}

	public void getRangeInput() {

		System.out.println("Gib dein Zahlenraum an:\n");
		Scanner sc = new Scanner(System.in);

		System.out.println("Minimum Zahl: ");
		do {

			this.input_range_down = sc.nextInt();

			if (this.input_range_down < 0) {
				System.out.println("Die Zahl darf nicht kleiner 0 sein!\n" + "Noch mal eingeben:");
			}

		} while (this.input_range_down < 0);

		System.out.println("Maximum Zahl: ");
		do {
			try {
				this.input_range_up = sc.nextInt();
				if (this.input_range_up - this.input_range_down == 0) {
					System.out.println("Die Grenzen duerfen nicht identisch sein!\n" + "Eingabe wiederholen\n\n");
					getRangeInput();
				}
			} catch (InputMismatchException e) {
				// hier könnte man eine M
				System.out.println("Error 42. Eingegebene Zahl zu gross!\n" + "");
				getRangeInput();
			}

			if (this.input_range_up >= Integer.MAX_VALUE) {
				System.out.println(
						"Die Zahl darf nicht groesser " + Integer.MAX_VALUE + " sein!\n" + "Noch mal eingeben:");
			}
		} while (this.input_range_up < 0);

//		return new int[] { this.input_range_down, this.input_range_up };
	}

	public int createRandomNumber(int min, int max) {

		System.out.println("Die Zufallszahl wird erzeugt\n");

		int randInt = min + (int) (Math.random() * ((max - min) + 1));

		return randInt;

	}

	public void guessIt() {
		getInputFromConsole();
		String answer = guessTheNumber(this.input_range_down, this.input_range_up, this.randInt);

		switch (answer) {
		case "ungueltig":
			System.out.println("\nUngueltige Eingabe! Eingabe wiederholen!");
			guessIt();
			break;
		case "groesser":
			System.out.println("\nDie gesuchte Zahl ist groesser!");
			guessIt();
			break;
		case "kleiner":
			System.out.println("\nDie gesuchte Zahl ist kleiner!");
			guessIt();
			break;
		case "gefunden":
			System.out.println("\nDu hast die gesuchte Zahl gefunden!");
			break;
		default:
			System.out.println("\nInternal Method failure.");
			break;
		}

	}
	
	public void getInputFromConsole() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bitte geben Sie eine Zahl ein: ");

		this.eingabe = sc.nextInt();
		
	}

	public String guessTheNumber(int min, int max, int randInt) {
		
		this.versuche++;		
		
		if (this.eingabe < min || this.eingabe > max) {
			return "ungueltig";

		} else if (this.eingabe < randInt) {

			return "groesser";

		} else if (this.eingabe > randInt) {

			return "kleiner";

		} else {
			return "gefunden";

		}

	}

}
