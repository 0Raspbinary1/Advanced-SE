package notes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import alles.HandleExit;

public class NotesStartSite {
	
	private static Map<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		setMap();
		Scanner sc = new Scanner(System.in);
		String input;
		String text = "Bitte wähle einen Modus aus:\n 1: Neue Notiz erstellen\n 2: Notizen auflisten\n S: Zum Start zurück\n "
				+ "X: Programm beenden \n...";
		System.out.println(text);
		
		input = sc.nextLine().toUpperCase();
		while(!map.containsKey(input)) {
			System.out.println("Falsche Eingabe, versuch es erneut:");
			input = sc.nextLine().toUpperCase();
		}
		if(map.get(input).equals("Start") || map.get(input).equals("Exit")) {
			HandleExit.perform(map.get(input), args);
		}else {
			new HandleNote(map.get(input), args);
		}
		sc.close();
	}
	private static void setMap() {
		map.put("1", "new");
		map.put("2", "list");
		map.put("X", "Exit");
		map.put("S", "Start");
	}

}
