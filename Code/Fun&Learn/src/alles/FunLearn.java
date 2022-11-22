package alles;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import convert.ConversionStartSite;


public class FunLearn {

	private static Map<String, String> map = new HashMap<>();
	private static String welcome = "Hallo und Herzlich Willkommen bei Fun&Learn!\n"
			+ "Du findest unten verschieden Modi, die du mithilfe von Zahlen auswaehlen kannst\n\n\n"
			+ "Modi auswaehlen: ";
	private static String modi = " 1: Spielen\n 2: Quiz\n 3: Notizen\n 4: Umrechnen";
	
	public static void main(String[] args) {
		System.out.println(welcome);
		setMap();
		askForInput(args);
	}

	private static void askForInput(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(modi);
		String input = sc.nextLine().toUpperCase();
		validateInput(input, args);
		sc.close();
	}

	private static void validateInput(String input, String [] args) {
		Scanner sc = new Scanner(System.in);
		while(!map.containsKey(input)) {
			System.out.println("Falsche Eingabe, versuch es erneut:");
			input = sc.nextLine().toUpperCase();
		}
		if(map.get(input).equals("Exit")) {
			HandleExit.perform(map.get(input), args);
		}else {
			openMode(map.get(input), args);
		}
		sc.close();
	}

	private static void openMode(String type, String[] args) {
		System.out.println("Sie haben " + type +" ausgewaehlt!");
		switch (type) {
		case "Game":
			play.Main.main(args);
			break;
		case "Quiz":
			break;
		case "Notizen":
			break;
		case "Umrechnen":
			ConversionStartSite.main(args);
			break;
		case "Exit":
			HandleExit.perform(type, args);
			break;
		}
	}

	private static void setMap() {
		map.put("1","Spielen");
		map.put("2", "Quiz");
		map.put("3", "Notizen");
		map.put("4", "Umrechnen");
		map.put("X", "Exit");
	}

}
