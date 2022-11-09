package umrechnen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConvertationStartSite {
	private static Map<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		setMap();
		Scanner sc = new Scanner(System.in);
		String input; 
		String text = "Was möchten Sie umrechnen? \n 1: Gewicht \n ...";
		System.out.println(text);
		
		input = sc.nextLine();
		while(!map.containsKey(input)) {
			System.out.println("Falsche Eingabe, versuch es erneut:");
			input = sc.nextLine();
		}
		
		new Convertation(map.get(input));
	}
	
	private static void setMap() {
		map.put("1", "Weighting");
	}
}
