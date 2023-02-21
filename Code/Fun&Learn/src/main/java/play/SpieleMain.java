package main.java.play;

import java.util.HashMap;
import java.util.Scanner;

import main.java.alles.HandleExit;
import main.java.alles.HandleInput;
import main.java.convert.Conversion;

public class SpieleMain {
	
	private static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		setMap();

		System.out.println("\nHallo und herzlich Willkommen im Spiele-Modus!\n" + 
		"Was moechtest du spielen?\n" + 
		"1: Zahlen raten\n" +
		"2: Schere Stein Papier\n" +
		"x: Programm beenden\n" +
		"s: Zurueck zum Hauptmenue");

		String input_game = HandleInput.getInput(map, System.in);
		if(input_game.equals("Start") || input_game.equals("Exit")) {
			HandleExit.perform(input_game, args);
		}else {
			if (input_game.equals("zahlen")) {
				new Zahlenraten().perform(args);
			}
			if(input_game.equals("schere")) {
				new SchereSteinPapier().start(args);;
			}
		}
	}
	
	private static void setMap() {
		map.put("1", "zahlen");
		map.put("2", "schere");
		map.put("X", "Exit");
		map.put("S", "Start");
	}
}
