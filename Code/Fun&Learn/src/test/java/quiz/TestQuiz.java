package test.java.quiz;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.quiz.DeutschlandF;
import main.java.quiz.ParseQuestions;
import main.java.quiz.Question;
import main.java.quiz.Quiz;

public class TestQuiz {
	String eingabe = "Deutschland";	
//	String[] args;
	ParseQuestions parseQ = new ParseQuestions(eingabe);
	String[][] questionArray = parseQ.getQuestions().getArray();
	String[] answers = new String[4];


	Quiz quiz = new Quiz(eingabe);
	DeutschlandF de = new DeutschlandF();
	
	
	@Test
	public void testValidateAnswerRightAnswer() {

		// Erste Frage in Deutschland
		String inputShouldBeCorrect = "c";
		String rightAnswer = this.de.getArray()[0][5];		
		assertEquals("Richtige Antwort", this.quiz.validateAnswer(inputShouldBeCorrect, rightAnswer));
	}
	
	@Test
	public void testValidateAnswerWrongAnswer() {
		// Erste Frage in Deutschland

		String input = "d";
		String rightAnswer = this.de.getArray()[0][5];		
		assertEquals("Falsche Antwort", this.quiz.validateAnswer(input, rightAnswer));
	}
	
	@Test
	public void testGetAnswers() {
//		for (int i = 0; i < this.twoDimQuestionArray.length; i++) {
//			for (int j = 0; i < 5; j++) {
//				this.twoDimQuestionArray[i][j] = this.de.getArray()[i][j];
//			}
//		}
//		this.parseQ.getAnswers(0, twoDimQuestionArray);
//
//		for (int i = 1; i < 5; i++) {
//			assertEquals(this.twoDimQuestionArray[0][i], this.parseQ.getAnswers(0, twoDimQuestionArray));
//		}
		
//		for(int i = 0; i < this.answers.length; i++) {
////			System.out.println(this.parseQ.getAnswers(0, questionArray)[i]);
//			System.out.println(this.parseQ);
////			assertEquals(this.answers[i], this.parseQ.getAnswers(0, questionArray)[i]);
//		}
		setAnswers();
		assertArrayEquals(this.answers, this.parseQ.getAnswers(0, this.questionArray));
	}
	
	public void setAnswers() {
		this.de.initQ();
		for(int i = 0; i < this.answers.length; i++) {
			this.answers[i] = this.de.getArray()[0][i+1];
		}
	}
	
}
