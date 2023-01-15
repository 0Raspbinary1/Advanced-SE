package main.java.quiz;

import java.util.HashMap;
import java.util.Scanner;

import main.java.alles.HandleExit;
import main.java.alles.HandleInput;

public class QuizMain {

	private static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		setMap();
		Scanner sc = new Scanner(System.in);

		System.out.println("Willkommen im Quizinatooorr\n\n"
				+ "Die Fragen sind mithilfe der Buchstaben zu beantworten!\n\n"
				+ "Welches Themengebiet moechtest du spielen?\n\n" 
				+ "1: Deutschland-Quiz\n" 
				+ "2: Astronomie-Quiz\n"
				+ "S: Zurueck zum Start\n"
				+ "X: Anwendung beenden\n");

		String input = HandleInput.getInput(map, System.in);
		
		if(input.equals("Start") || input.equals("Exit")) {
			HandleExit.perform(input, args);
		}else {
			startQuiz(input, args);
		}
		sc.close();
	}

	public static void startQuiz(String eingabe, String [] args) {
		new Quiz(eingabe).perform(args);
	}
	
	private static void setMap() {
		map.put("1", "Deutschland");
		map.put("2", "Astronomie");
		map.put("X", "Exit");
		map.put("S", "Start");
	}
}
