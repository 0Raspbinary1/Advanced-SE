package main.java.convert;

import java.util.HashMap;

import main.java.all.HandleExit;
import main.java.all.HandleInput;


public class ConversionStartSite {
	private static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		setMap();
		String text = "Was moechten Sie umrechnen? \n 1: Gewicht \n 2: Laengenangaben \n 3: Temperaturen \n 4: Flaeche \n"
				+ " 5: Zeit \n S: Zum Start zurueck \n X: Programm beenden \n...";
		System.out.println(text);
		
		String input = HandleInput.getInput(map, System.in, false);
		if(input.equals("Start") || input.equals("Exit")) {
			HandleExit.perform(input, args);
		}else {
			new Conversion(input, System.in).perform(args);
		}
	}
	
	private static void setMap() {
		map.put("1", "Weighting");
		map.put("2", "Length");
		map.put("3", "Temperature");
		map.put("4", "Area");
		map.put("5", "Time");
		map.put("X", "Exit");
		map.put("S", "Start");
	}
}
