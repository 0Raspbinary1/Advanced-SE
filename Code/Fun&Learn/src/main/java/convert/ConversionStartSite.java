package main.java.convert;

import java.util.HashMap;

import main.java.alles.HandleExit;
import main.java.alles.HandleInput;


public class ConversionStartSite {
	private static HashMap<String, Object> map = new HashMap<>();
	private static String text;
	public static void main(String[] args) {
		setMap();
//		String text = "Was moechten Sie umrechnen? \n 1: Gewicht \n 2: Laengenangaben \n 3: Temperaturen \n 4: Flaeche \n"
//				+ " 5: Zeit \n S: Zum Start zurueck \n X: Programm beenden \n...";
		System.out.println(text);
		
		Object input = HandleInput.getInput(map, System.in);
		if(input.toString().equals("Start") || input.toString().equals("Exit")) {
			HandleExit.perform(input.toString(), args);
		}else {
			new Conversion((ConversionType) input, args, System.in);
		}
	}
	
	private static void setMap() {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append("Was moechten Sie umrechnen? \n ");
		int index = 0;
		for (ConversionType type : ConversionType.values()) {
			String stringType = type.toString();
			String stringIndex = ""+ ++index;
			map.put(stringIndex, type);
			textBuilder.append(stringIndex + ": "+ stringType + "\n ");
		}
		textBuilder.append("S: Zum Start zurueck \n X: Programm beenden \n...");
		text = textBuilder.toString();
//		map.put("1", "Weighting");
//		map.put("2", "Length");
//		map.put("3", "Temperature");
//		map.put("4", "Area");
//		map.put("5", "Time");
		map.put("X", "Exit");
		map.put("S", "Start");
	}
}
