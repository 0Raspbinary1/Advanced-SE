package main.java.notes;

import java.util.HashMap;

import main.java.all.HandleExit;
import main.java.all.HandleInput;


public class NotesStartSite {
	
	private static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		setMap();
		String text = "Bitte waehle einen Modus aus:\n 1: Neue Notiz erstellen\n 2: Notizen auflisten\n S: Zum Start zurueck\n "
				+ "X: Programm beenden \n...";
		System.out.println(text);
		
		String input = HandleInput.getInput(map, System.in, false);
		if(input.equals("Start") || input.equals("Exit")) {
			HandleExit.perform(input, args);
		}else {
			new HandleNote(input, args, System.in);
		}
	}
	private static void setMap() {
		map.put("1", "new");
		map.put("2", "list");
		map.put("X", "Exit");
		map.put("S", "Start");
	}

}
