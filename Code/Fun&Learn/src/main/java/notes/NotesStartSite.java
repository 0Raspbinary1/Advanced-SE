package main.java.notes;

import java.util.HashMap;

import main.java.alles.HandleExit;
import main.java.alles.HandleInput;
import main.java.convert.ConversionType;


public class NotesStartSite {
	
	private static HashMap<String, Object> map = new HashMap<>();
	private static String text;
	public static void main(String[] args) {
		setMap();
//		String text = "Bitte waehle einen Modus aus:\n 1: Neue Notiz erstellen\n 2: Notizen auflisten\n S: Zum Start zurueck\n "
//				+ "X: Programm beenden \n...";
		System.out.println(text);
		
		Object input = HandleInput.getInput(map, System.in);
		String inputAsString = input.toString();
		if(inputAsString.equals("Start") || inputAsString.equals("Exit")) {
			HandleExit.perform(inputAsString, args);
		}else {
			new HandleNote((NotesTypes) input, args, System.in);
		}
	}
	private static void setMap() {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append("Bitte waehle einen Modus aus:\n ");
		int index = 0;
		for (NotesTypes type : NotesTypes.values()) {
			String stringType = type.toString();
			String stringIndex = ""+ ++index;
			map.put(stringIndex, type);
			textBuilder.append(stringIndex + ": "+ stringType + "\n ");
		}
		textBuilder.append("S: Zum Start zurueck \n X: Programm beenden \n...");
		text = textBuilder.toString();
//		map.put("1", "new");
//		map.put("2", "list");
		map.put("X", "Exit");
		map.put("S", "Start");
	}

}
