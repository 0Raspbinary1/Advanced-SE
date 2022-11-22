package Spielen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int auswahl;

		System.out.println("Willkommen im Spielmodus!");
		System.out.println("Was wollen Sie spielen?:");

		System.out.println("1: Zahlen raten");
		System.out.println("2: Schere Stein Papier");
		System.out.println("3: Zahlen raten");

		auswahl = sc.nextInt();

		if (auswahl == 1) {
			System.out.println("Sie haben Zahlen raten ausgewaehlt");
			System.out.println("Zum beginnen: 1 enter");
			int begin1 = sc.nextInt();
			if(begin1 == 1) {
				System.out.println("Spiel beginnt");
			}
		}
		if (auswahl == 2) {

		}
		if (auswahl == 3) {

		}
		sc.close();
	}

}
