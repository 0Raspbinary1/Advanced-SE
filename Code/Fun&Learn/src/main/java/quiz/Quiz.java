package main.java.quiz;

import java.util.HashMap;

import main.java.all.HandleInput;

public class Quiz {

	private HashMap<String, String> charMap = new HashMap<>();
	private int score = 0;
	private Question [] questions;

	
	public Quiz(String eingabe) {
		this.setCharMap();
		ParseQuestions parseQ = new ParseQuestions(eingabe);
		parseQ.parseQuestions();
		this.questions = parseQ.getQuestionArray();
	}

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public void perform(String [] args) {
		for(int i = 0; i < this.questions.length;i++) {
			System.out.println(this.questions[i].getQuestion());
			printAnswers(this.questions[i].getAnwsers());
			String guess = HandleInput.getInput(this.charMap, System.in, false);
			System.out.println(validateAnswer(guess, this.questions[i].getRightAnswer()));
			System.out.println("Deine aktuelle Punktzahl betraegt: "+ this.score + "\n\n");
		}
		System.out.println("Quiz zu Ende. "+ this.score +" von moeglichen " + questions.length + " Punkten erreicht\n\n");
		QuizMain.main(args);;
	}

	public String validateAnswer(String guess, String rightAnswer) {
		if(guess.equals(rightAnswer)) {
			System.out.println("Richtige Antwort");
			this.score++;
			return "Richtige Antwort";
		}else {
			System.out.println("Falsche Antwort");
			return "Falsche Antwort";
		}
		
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