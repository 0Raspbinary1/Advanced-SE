package main.java.Quiz;

import java.util.HashMap;
import java.util.Map;

public class Question {

	DeutschlandF de = new DeutschlandF();
	AstronomieF as = new AstronomieF();

	// unnoetig String[][] q;

	Question[] questionArr;

	String question;
	String[] answers = new String[4];
	String answer;

	public Question() {

//		switch (typ.toLowerCase()) {
//		case "deutschland":
//			de = new DeutschlandF();
//			this.q = de.de;
//
//		case "astronomie":
//			as = new AstronomieF();
//			this.q = as.as;
//		}
	}

	// koennte man dynamisch machen (nicht fuer jede Kategorie eine Methode)
	// das kommt dann in das Review etc. mit rein
	public void initQuestionDE() {
		questionArr = new Question[de.de.length];

		for (int i = 0; i < this.de.de.length; i++) {
			this.questionArr[i] = new Question();
			this.questionArr[i].answers[0] = this.de.de[i][1];
			this.questionArr[i].answers[1] = this.de.de[i][2];
			this.questionArr[i].answers[2] = this.de.de[i][3];
			this.questionArr[i].answers[3] = this.de.de[i][4];

			for (int j = 0; j < 6; j++) {
				if (j == 0) {
					this.questionArr[i].question = this.de.de[i][j];

				}
				if (j == 5) {
					this.questionArr[i].answer = this.de.de[i][j];
				}
			}
		}

		/*
		 * System.out.println("TESTING TESTING\n\n\n\n\n"); for (int i = 0; i <
		 * this.de.de.length; i++) { System.out.println(this.questionArr[i].answers[0]);
		 * System.out.println(this.questionArr[i].answers[1]);
		 * System.out.println(this.questionArr[i].answers[2]);
		 * System.out.println(this.questionArr[i].answers[3]);
		 * 
		 * } System.out.println("TESTEND TESTEND");
		 */
	}

	public void initQuestionAS() {
		questionArr = new Question[as.as.length];

		for (int i = 0; i < this.as.as.length; i++) {
			this.questionArr[i] = new Question();
			this.questionArr[i].answers[0] = this.as.as[i][1];
			this.questionArr[i].answers[1] = this.as.as[i][2];
			this.questionArr[i].answers[2] = this.as.as[i][3];
			this.questionArr[i].answers[3] = this.as.as[i][4];

			for (int j = 0; j < 6; j++) {
				if (j == 0) {
					this.questionArr[i].question = this.as.as[i][j];

				}
				if (j == 5) {
					this.questionArr[i].answer = this.as.as[i][j];
				}
			}
		}
	}

//	public void initializeDeutschlandFragen(DeutschlandF de) {
//		this.frage = de.frage;
//	}
//
//	public void initializeAstronomieFragen() {
//
//	}

//	Map<String, String[]> mapAstronomie = new HashMap<String, String[]>();
//	Map<String, String[]> mapDeutschland = new HashMap<String, String[]>();
//	
//	Map<String, String[]> quiz = new HashMap<String, String[]>();
//	
//	
//
//	public Question(String type, String question, String[] answers) {
//		if(type.equals("astronomie")) {
//			this.createAstronomieQuiz(question, answers);
//		} else if(type.equals("deutschland")) {
//			this.createDeutschlandQuiz(question, answers);
//		}
//	}
//	
//	public void createAstronomieQuiz(String question, String[] answers) {
//		this.mapAstronomie.put(question, answers);
//	}
//	
//	public void createDeutschlandQuiz(String question, String[] answers) {
//		this.mapDeutschland.put(question, answers);
//	}

}