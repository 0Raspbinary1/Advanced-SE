package alles;
import java.util.Scanner;

import Quiz.QuizMain;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;

		System.out.print("Hallo und Herzlich Willkommen bei Fun&Learn!");
		System.out.print("Du findest unten verschieden Modi, die du mithilfe von Zahlen auswählen kannst\n\n\n");
		System.out.println("Modi auswählen: ");

		// Modi auswählen

		System.out.println("1: Spielen");
		System.out.println("2: Quiz");
		System.out.println("3: Notizen");
		System.out.println("4: Umrechnen");

		input = sc.nextInt();

		if (input == 1) {
			System.out.println("Sie haben Spielen ausgewählt!");
			
		}

		if (input == 2) {
			System.out.println("Sie haben Quiz ausgewählt!");
			try {
				QuizMain.main(args);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (input == 3) {
			System.out.println("Sie haben Notizen ausgewählt!");
		}

		if (input == 4) {
			System.out.println("Sie haben Umrechnen ausgewählt!");
		}
		
	}

}
