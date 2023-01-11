package main.java.Quiz;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.alles.HandleExit;


public class QuizMain {
	private static Map<String, String> map = new HashMap<>();
	public static void main(String[] args) throws InterruptedException {
		setMap();
		Scanner sc = new Scanner(System.in);
		
		//könnte man hier noch dynamisch machen
		System.out.println("Willkommen im Quizinatooorr\n\n"
				+ "Die Fragen sind mithilfe der Buchstaben zu beantworten!\n\n"
				+ "Was möchtest du spielen / machen?\n\n" 
				+ "1: Deutschland-Quiz\n" 
				+ "2: Astronomie-Quiz\n"
				+ "S: Zurück zum Start\n"
				+ "X: Anwendung beenden");

		String input = sc.nextLine().toUpperCase();
		System.out.println(input);
		while(!map.containsKey(input)) {
			System.out.println("Falsche Eingabe, versuch es erneut:");
			input = sc.nextLine().toUpperCase();
		}
		if(map.get(input).equals("Start") || map.get(input).equals("Exit")) {
			System.out.println("Du hast " + map.get(input) + " gewählt!");
//			if(map.get(input).equals("Exit")) {
//				System.out.println("why did you do this to me?? :(");
//					StringBuffer str = new StringBuffer();
//					Thread.sleep(1200);
//					for(int i = 0; i < 6; i++) {
//						Thread.sleep(300);
//						System.out.print("#");
//					}
//					str = new StringBuffer();
//					System.out.print(" R");
//					Thread.sleep(1500);
//					System.out.print("I");
//					Thread.sleep(1500);
//					System.out.print("P ");
//					for(int i = 0; i < 6; i++) {
//						Thread.sleep(300);
//						System.out.print("#");
//					}
//			}
			HandleExit.perform(map.get(input), args);
		}else {
			//new Conversion(map.get(input), args);
			new Quiz(map.get(input).toUpperCase(), args);
		}
		sc.close();	
	}
	
	private static void setMap() {
		map.put("1", "Deutschland");
		map.put("2", "Astronomie");
		map.put("X", "Exit");
		map.put("S", "Start");
	}

// ----------------------------------------------------------------------------
	

//		String frage1 = "Wie weit etwa ist die Sonne im Durchschnitt von der Erde entfernt?";
//		String[] antworten = {"c) 150.000.000 km","a) 10.000 km", "b) 12.000.000.000 km", "d) 380.000 km"};
//		Question q1 = new Question("deutschland", frage1, antworten);
//		
//		System.out.println("Willkommen im Quizinatooorr\n\n"
//				+ "Die Fragen sind mithilfe der Buchstaben zu beantworten!\n\n");
//		
////		String q1 = "Welche Farbe hat ein Apfel?\n\n"
////					+ "a) rot / grün \n"
////					+ "b) gelb\n"
////					+ "c) weiß\n"
////					+ "d) blau";
////		String q2 = "Welche Farbe haben Bananen?\n\n"
////					+ "a) schwarz\n"
////					+ "b) gelb \n"
////					+ "c) orange \n"
////					+ "d) rosa";
//		
//		
//
//		
//	}
//	
//	public static void takeQuiz(Question [] questions) {
//		int score = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		for (int i = 0; i < questions.length; i++) {
//			System.out.println(questions[i].prompt);
//			String answer = sc.nextLine().toLowerCase();
//			if(answer.equals(questions[i].answer)) {
//				score++;
//			}
//		}
//		
//		System.out.println("Du hast " + score + " von " + questions.length + " richtig beantwortet!");
//		sc.close();
//	}

	// Testen
//	public static void testDeF() {
//		DeutschlandF def = new DeutschlandF();
//		def.initQ();
//		String d[][] = def.de;
//
//		for (int i = 0; i < d.length; i++) {
//			for (int j = 0; j <= 5; j++) {
//				if (d[i][j] != null) {
//					System.out.println(d[i][j]);
//				}
//			}
//		}
//	}
//
//	public static void testAsF() {
//		AstronomieF asf = new AstronomieF();
//		asf.initQ();
//		String d[][] = asf.as;
//
//		for (int i = 0; i < d.length; i++) {
//			for (int j = 0; j <= 5; j++) {
//				if (d[i][j] != null) {
//					System.out.println(d[i][j]);
//				}
//			}
//		}
//	}

}
