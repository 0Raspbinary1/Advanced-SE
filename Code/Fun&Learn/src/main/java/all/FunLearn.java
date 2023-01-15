package main.java.all;
import java.util.HashMap;

import main.java.convert.ConversionStartSite;
import main.java.notes.NotesStartSite;
import main.java.play.Main;


public class FunLearn {
	
	private static HashMap<String, String> map = new HashMap<String, String>();
	private static String welcome = "Hallo und Herzlich Willkommen bei Fun&Learn!\n"
			+ "Du findest unten verschieden Modi, die du mithilfe von Zahlen auswaehlen kannst\n\n\n"
			+ "Modi auswaehlen: ";
	private static String modi = " 1: Spielen\n 2: Quiz\n 3: Notizen\n 4: Umrechnen\n X: Programm beenden";
	
	public static void main(String[] args) {
		System.out.println(welcome);
		setMap();
		askForInput(args);
	}

	private static void askForInput(String [] args) {
		System.out.println(modi);
		validateInput(args);
	}

	private static void validateInput(String [] args) {
		String input = HandleInput.getInput(map, System.in, false);
		if(input.equals("Exit")) {
			HandleExit.perform(input, args);
		}else {
			openMode(input, args);
		}
	}

	private static void openMode(String type, String[] args) {
		System.out.println("Sie haben " + type +" ausgewaehlt!");
		switch (type) {
		case "Game":
			Main.main(args);
			break;
		case "Quiz":
			break;
		case "Notizen":
			NotesStartSite.main(args);
			break;
		case "Umrechnen":
			ConversionStartSite.main(args);
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
