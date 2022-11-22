package alles;
import java.util.Scanner;

public class FunLearn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;

		System.out.print("Hallo und Herzlich Willkommen bei Fun&Learn! ");
		System.out.print("Du findest unten verschieden Modi, die du mithilfe von Zahlen auswaehlen kannst\n\n\n");
		System.out.println("Modi auswaehlen: ");

		// Modi auswaehlen

		System.out.println("1: Spielen");
		System.out.println("2: Quiz");
		System.out.println("3: Notizen");
		System.out.println("4: Umrechnen");

		input = sc.nextInt();

		if (input == 1)	{
			System.out.println("Sie haben Spielen ausgewaehlt!"); 
			Spielen.Main.main(args);
		}

		if (input == 2) {
			System.out.println("Sie haben Quiz ausgewaehlt!");
		}
		if (input == 3) {
			System.out.println("Sie haben Notizen ausgewaehlt!");
		}

		if (input == 4) {
			System.out.println("Sie haben Umrechnen ausgewählt!");
			convert.ConversionStartSite.main(args);
		}
	}

}
