package main.java.Quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.all.HandleExit;

public class Quiz {

	private static Map<String, String> map = new HashMap<>();
	DeutschlandF de = new DeutschlandF();
	AstronomieF as = new AstronomieF();
	Question q = new Question();
	private int score = 0;
	String[] args;

	public Quiz(String eingabe, String[] args) {
		setMap();
		this.args = args;
		switch (eingabe.toUpperCase()) {
		case "DEUTSCHLAND":
			this.q.initQuestionDE();
			startQuiz();
			break;
		case "ASTRONOMIE":
			this.q.initQuestionAS();
			startQuiz();
			break;
		}
	}

	public void startQuiz() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		System.out.println("Willkommen! \n\n");
		for (int i = 0; i < this.q.questionArr.length; i++) {
			System.out.println(this.q.questionArr[i].question);
			for (int j = 0; j < 4; j++) {
				System.out.println(this.q.questionArr[i].answers[j]);
			}
			input = sc.nextLine();
			if (input.equals(q.questionArr[i].answer)) {
				System.out.println("korrket!");
				this.score++;
			}
		}
		System.out.println("Gesamt Score: " + this.score);
		// dynamisch machen
		System.out.println("1: Quizmenue\n" + "X: Anwendung beenden\n" + "S: Startmenue");
		input = sc.nextLine().toUpperCase();
		if(input.equals("1")) {
			try {
				QuizMain.main(this.args);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		if(map.get(input).equals("Start") || map.get(input).equals("Exit")) {
				HandleExit.perform(map.get(input), this.args);
		}
	}

	public int getScore() {
		return score;
	}
	
	private static void setMap() {
		map.put("1", "Hauptmenue");
		map.put("X", "Exit");
		map.put("S", "Start");
	}

//------------------------------------------------------------------	

}
