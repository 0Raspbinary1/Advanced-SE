package main.java.alles;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class HandleInput {
	public static String getInput(HashMap<String, String> map, InputStream systemIn) {
		Scanner sc = new Scanner(systemIn);
		String input = sc.nextLine().toUpperCase();
		System.out.println(systemIn);
		while(!map.containsKey(input)) {
			System.out.println("Falsche Eingabe, versuch es erneut:");
			input = sc.nextLine().toUpperCase();
		}
		return input;
	}
}
