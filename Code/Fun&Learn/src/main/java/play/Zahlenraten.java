package main.java.play;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {

	int input_range_down;
	int input_range_up;

	int randInt;

	public int eingabe;

	int versuche = 0;

	Scanner scanner;
	InputStream inputStream;
	
	public int getEingabe() {
		return this.eingabe;
	}
	
	public void setEingabe(int eingabe) {
		this.eingabe = eingabe;
	}

	public Zahlenraten(InputStream inStream) {
		System.out.println("\nWillkommen beim Zahlenraten!\n");
		this.inputStream = inStream;
		this.scanner = new Scanner(inStream);
	}

	public void perform(String[] args) {
//		bool ..
//		do aufruf und speicherugn in bool
//		whilke nicht bool

//		boolean rangeInputIsOK;
//		do {
//			rangeInputIsOK = getRangeInput();
//		} while(!rangeInputIsOK);
		setRangeInput();

		this.randInt = createRandomNumber(this.input_range_down, this.input_range_up);

		System.out.println("Die Zufallszahl liegt zwischen " + this.input_range_down + " und " + this.input_range_up);

		guessIt();

		System.out.println("Die Zufallszahl " + randInt + " wurde im " + this.versuche + ". Versuch erraten!");

		SpieleMain.main(args);
	}

	public int readInteger() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Geben Sie eine Ganzzahl ein: ");
		int value = scanner.nextInt();
		scanner.close();
		return value;
	}

	public void setRangeInput() {

		System.out.println("Gib dein Zahlenraum an:\n");

		setRangeDown();
		setRangeUp();

	}

	public void setRangeDown() {
		boolean retry = false;

		System.out.println("Minimum Zahl: ");
		do {

			this.input_range_down = this.scanner.nextInt();
			if (this.input_range_down < 0) {
				System.out.println("Die Zahl darf nicht kleiner 0 sein!\n" + "Noch mal eingeben:");
				retry = true;
			} else {
				retry = false;
			}

		} while (retry);

	}

	public void setRangeUp() {
		boolean retry = false;
		System.out.println("Maximum Zahl: ");
		
		do {
			this.input_range_up = this.scanner.nextInt();
			if (this.input_range_up - this.input_range_down == 0) {
				System.out.println("Die Grenzen duerfen nicht identisch sein!\n" + "Eingaben wiederholen\n\n");
				setRangeInput();
				retry = false;
			} else if (this.input_range_up >= Integer.MAX_VALUE) {
				System.out.println(
						"Die Zahl darf nicht groesser " + Integer.MAX_VALUE + " sein!\n" + "Noch mal eingeben:");
				retry = true;
			} else if(this.input_range_up > this.input_range_down) {
				retry = false;
			}
		} while (retry);
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

		System.out.println("Bitte geben Sie eine Zahl ein: ");

		this.eingabe = this.scanner.nextInt();

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
