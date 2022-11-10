package Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizMain {

	public static void main(String[] args) {
		String frage1 = "Wie weit etwa ist die Sonne im Durchschnitt von der Erde entfernt?";
		String[] antworten = {"c) 150.000.000 km","a) 10.000 km", "b) 12.000.000.000 km", "d) 380.000 km"};
		Question q1 = new Question("deutschland", frage1, antworten);
		
		System.out.println("Willkommen im Quizinatooorr\n\n"
				+ "Die Fragen sind mithilfe der Buchstaben zu beantworten!\n\n");
		
//		String q1 = "Welche Farbe hat ein Apfel?\n\n"
//					+ "a) rot / grün \n"
//					+ "b) gelb\n"
//					+ "c) weiß\n"
//					+ "d) blau";
//		String q2 = "Welche Farbe haben Bananen?\n\n"
//					+ "a) schwarz\n"
//					+ "b) gelb \n"
//					+ "c) orange \n"
//					+ "d) rosa";
		
		

		
	}
	
	public static void takeQuiz(Question [] questions) {
		int score = 0;
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i].prompt);
			String answer = sc.nextLine().toLowerCase();
			if(answer.equals(questions[i].answer)) {
				score++;
			}
		}
		
		System.out.println("Du hast " + score + " von " + questions.length + " richtig beantwortet!");
		sc.close();
	}

}
