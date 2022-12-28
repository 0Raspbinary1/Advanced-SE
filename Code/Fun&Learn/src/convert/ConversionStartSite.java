package convert;

import java.util.HashMap;

import alles.HandleExit;
import alles.HandleInput;

public class ConversionStartSite {
	private static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		setMap();
		String text = "Was möchten Sie umrechnen? \n 1: Gewicht \n 2: Längenangaben \n 3: Temperaturen \n 4: Fläche \n"
				+ " 5: Zeit \n S: Zum Start zurück \n X: Programm beenden \n...";
		System.out.println(text);
		
		String input = HandleInput.getInput(map);
		if(map.get(input).equals("Start") || map.get(input).equals("Exit")) {
			HandleExit.perform(map.get(input), args);
		}else {
			new Conversion(map.get(input), args);
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
