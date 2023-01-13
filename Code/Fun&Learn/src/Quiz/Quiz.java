package Quiz;

import java.util.Scanner;

public class Quiz {

	private int score = 0;
	private Question [] questions;
	
	public Quiz(String eingabe) {
		ParseQuestions parse = new ParseQuestions(eingabe);
		this.questions = parse.getQuestionArray();
	}

	public void perform(String [] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i <this.questions.length;i++) {
			System.out.println(this.questions[i].getQuestion());
			printAnswers(this.questions[i].getAnwsers());
			String guess = sc.nextLine();
			validateAnswer(guess, this.questions[i].getRightAnswer());
		}
		System.out.println("Quiz zu Ende, "+ this.score +" Punkte erreicht");
		sc.close();
		QuizMain.main(args);
	}

	private void validateAnswer(String guess, String rightAnswer) {
		if(guess.equals(rightAnswer)) {
			System.out.println("Richtige Antwort");
			this.score++;
		}else {
			System.out.println("Falsche Antwort");
		}
		System.out.println("Deine aktuelle Punktzahl betraegt: "+ this.score +"\n\n");
	}

	private void printAnswers(String[] answers) {
		char index = 'a';
		for(int i =0; i< answers.length; i++) {
			System.out.println(index++ + ": "+ answers[i]);
		}
	}

}
