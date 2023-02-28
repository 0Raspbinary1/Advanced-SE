package main.java.quiz;

public class Question {
	
	private String question;
	private String [] answers;
	private String rightAnswer;
	
	public String getQuestion() {
		return question;
	}

	public String[] getAnwsers() {
		return answers;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	
	public Question(String question, String[] answers, String rightAnswer) {
		this.question = question;
		this.answers = answers;
		this.rightAnswer = rightAnswer;
	}

}
