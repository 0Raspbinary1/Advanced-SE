package Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Quiz.DeutschlandF;

public class Quiz {

	DeutschlandF de = new DeutschlandF();
	AstronomieF as = new AstronomieF();
	Question q = new Question();
	
	private int score = 0;
//	Question[] question;
	
	public Quiz(String eingabe) {
		switch(eingabe.toUpperCase()) {
		case "DEUTSCHLAND": this.q.initQuestionDE(); startQuiz(); break;
		case "ASTRONOMIE": initQuestionAS();
		}
	}
	
	public void startQuiz() {
		System.out.println("Quiz.startQuiz");
		Scanner sc = new Scanner(System.in);
		String input = "";
		System.out.println("Willkommen :)\n\n");
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
	}

	public int getScore() {
		return score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void initQuestionDE() {
//		for (int i = 0; i < this.de.de.length; i++) {
//			this.question[i] = new Question();
//			
//			for (int j = 0; j < 6; j++) {
//				if(j == 0) {
//					this.question[i].question = this.de.de[i][j];
//					
//				}
//				if(j == 5) {
//					this.question[i].answer = this.de.de[i][j];
//				}
//				//if (j == 1 || j == 2 || j == 3 || j == 4) {
//					this.question[i].answers[0] = this.de.de[i][1];
//					this.question[i].answers[1] = this.de.de[i][2];
//					this.question[i].answers[2] = this.de.de[i][3];
//					this.question[i].answers[3] = this.de.de[i][4];
//				//}
//			}
//		}
//	}
	
	public void initQuestionAS() {
		
	}
	

	
	
	
}
