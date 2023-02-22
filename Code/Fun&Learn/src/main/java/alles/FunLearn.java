package main.java.alles;
import java.util.HashMap;

import main.java.convert.ConversionStartSite;
import main.java.convert.ConversionType;
import main.java.notes.NotesStartSite;
import main.java.play.Main;
import main.java.quiz.QuizMain;


public class FunLearn {
	
	private static HashMap<String, Object> map = new HashMap<>();
	private static String welcome = "Hallo und Herzlich Willkommen bei Fun&Learn!\n"
			+ "Du findest unten verschiedene Modi, die du mithilfe von Zahlen auswaehlen kannst\n\n\n"
			+ "Modi auswaehlen: ";
//	private static String modi = " 1: Spielen\n 2: Quiz\n 3: Notizen\n 4: Umrechnen\n X: Programm beenden";
	private static String text;
	public static void main(String[] args) {
		System.out.println(welcome);
		setMap();
		askForInput(args);
	}

	private static void askForInput(String [] args) {
		System.out.println(text);
		validateInput(args);
	}

	private static void validateInput(String [] args) {
		Object input = HandleInput.getInput(map, System.in);
		String inputString = input.toString();
		if(inputString.equals("Exit")) {
			HandleExit.perform(inputString, args);
		}else {
			openMode((ModeTypes) input, args);
		}
	}

	private static void openMode(ModeTypes type, String[] args) {
		System.out.println("Sie haben " + type +" ausgewaehlt!");
		switch (type) {
		case SPIELEN:
			Main.main(args);
			break;
		case QUIZ:
			QuizMain.main(args);
			break;
		case NOTIZEN:
			NotesStartSite.main(args);
			break;
		case UMRECHNEN:
			ConversionStartSite.main(args);
			break;
		}
	}

	private static void setMap() {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append(" \n ");
		int index = 0;
		for (ModeTypes type : ModeTypes.values()) {
			String stringType = type.toString();
			String stringIndex = ""+ ++index;
			map.put(stringIndex, type);
			textBuilder.append(stringIndex + ": "+ stringType + "\n ");
		}
		textBuilder.append(" X: Programm beenden \n...");
		text = textBuilder.toString();
		map.put("X", "Exit");
	}
}