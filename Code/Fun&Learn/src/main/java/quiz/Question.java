package main.java.quiz;

public class Question {

//	DeutschlandF de = null;
//	AstronomieF as = null;
	
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
