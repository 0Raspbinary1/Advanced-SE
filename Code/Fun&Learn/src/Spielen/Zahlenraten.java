package Spielen;

import java.util.Random;
import java.util.Scanner;

public class Zahlenraten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input_range_down = 0;
		int input_range_up = 0;

		System.out.println("Willkommen beim Zahlenraten!\n\n");
		System.out.println("Gib dein Zahlenraum an:\n" + "mindest Zahl: ");

		input_range_down = sc.nextInt();
		input_range_up = sc.nextInt();
		start(input_range_down, input_range_up);

	}

	public static void start(int min, int max) {
		Scanner sc = new Scanner(System.in);
		boolean aktiv = true;

		while (aktiv) {
			System.out.println("Die Zufallszahl liegt zwischen " + min + " und " + max);

			int randInt = min + (int) (Math.random() * ((max - min) + 1));

			int eingabe = 0;
			int versuche = 1;

			while (true) {
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
					System.out.println("Du hast die gesuchte Zahl gefunden!");
					System.out.println("Die Zufallszahl " + randInt + " wurde in " + versuche + " Veruschen gefunden!");
					break;
				}
			}

			System.out.println("Noch einmal spielen? (1 = Ja. | 2 = Nein.)");
			eingabe = sc.nextInt();

			if (eingabe == 2) {
				aktiv = false;
			}
		}

	}
}
