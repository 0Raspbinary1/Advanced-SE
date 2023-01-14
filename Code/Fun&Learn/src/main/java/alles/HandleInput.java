package main.java.alles;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class HandleInput {
	public static String getInput(HashMap<String, String> map, InputStream systemIn) {
		Scanner sc = new Scanner(systemIn);
		String input = sc.nextLine().toUpperCase();
		while(!map.containsKey(input)) {
			if(systemIn instanceof BufferedInputStream) {
				System.out.println("Falsche Eingabe, versuch es erneut:");
				input = sc.nextLine().toUpperCase();
			}else {
				return "false input";
			}
		}
		return map.get(input);
	}
}