package Quiz;

import java.util.HashMap;
import java.util.Map;

public class Question {

	DeutschlandF de = null;
	AstronomieF as = null;

	public Question(String typ) {

		switch (typ.toLowerCase()) {
		case "deutschland":
			de = new DeutschlandF();
		case "astronomie":
			as = new AstronomieF();
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
