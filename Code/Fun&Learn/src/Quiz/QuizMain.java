package Quiz;

import java.util.Scanner;

public class QuizMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Willkommen im Quizinatooorr\n\n"
				+ "Die Fragen sind mithilfe der Buchstaben zu beantworten!\n\n"
				+ "Welche Themengebiet m�chstest du spielen?\n\n" 
				+ "de: Deutschland-Quiz\n" 
				+ "ar: Astronomie-Quiz");

		String eingabe = sc.nextLine();
		startQuiz(eingabe, args);
		sc.close();
	}

	public static void startQuiz(String eingabe, String [] args) {
		new Quiz(eingabe).perform(args);
	}
}
