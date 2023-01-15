package main.java.quiz;

import java.util.HashMap;

import main.java.alles.HandleInput;

public class Quiz {

	private HashMap<String, String> charMap = new HashMap<>();
	private int score = 0;
	private Question [] questions;

	
	public Quiz(String eingabe) {
		this.setCharMap();
		this.questions = new ParseQuestions(eingabe).getQuestionArray();
	}

	public void perform(String [] args) {
		for(int i = 0; i <this.questions.length;i++) {
			System.out.println(this.questions[i].getQuestion());
			printAnswers(this.questions[i].getAnwsers());
			String guess = HandleInput.getInput(this.charMap, System.in);
			validateAnswer(guess, this.questions[i].getRightAnswer());
		}
		System.out.println("Quiz zu Ende. "+ this.score +" von moeglichen " + questions.length + " Punkten erreicht\n\n");
		QuizMain.main(args);;
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
	
	private void setCharMap() {
		charMap.put("A", "a");
		charMap.put("B", "b");
		charMap.put("C", "c");
		charMap.put("D", "d");
	}
}