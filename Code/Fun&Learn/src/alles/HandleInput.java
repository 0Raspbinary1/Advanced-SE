package alles;

import java.util.HashMap;
import java.util.Scanner;

public class HandleInput {
	public static String getInput(HashMap<String, String> map) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toUpperCase();
		while(!map.containsKey(input)) {
			System.out.println("Falsche Eingabe, versuch es erneut:");
			input = sc.nextLine().toUpperCase();
		}
		return input;
	}
}
