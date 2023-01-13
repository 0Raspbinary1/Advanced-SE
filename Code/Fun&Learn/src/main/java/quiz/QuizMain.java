package main.java.quiz;

import java.util.Scanner;

public class QuizMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Willkommen im Quizinatooorr\n\n"
				+ "Die Fragen sind mithilfe der Buchstaben zu beantworten!\n\n"
				+ "Welches Themengebiet moechtest du spielen?\n\n" 
				+ "de: Deutschland-Quiz\n" 
				+ "as: Astronomie-Quiz");

		String eingabe = sc.nextLine();
		startQuiz(eingabe, args);
		sc.close();
	}

	public static void startQuiz(String eingabe, String [] args) {
		new Quiz(eingabe).perform(args);
	}
}
