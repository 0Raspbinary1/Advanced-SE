package Quiz;

public class ParseQuestions {
	
	private Questions questions;
	private Question[] questionArray;
	
	public ParseQuestions(String typ) {
		switch(typ) {
			case "de":
				this.questions = new DeutschlandF();
				break;
			case "ar":
				questions = new AstronomieF();
		}
		parseQuestions();
	}

	private void parseQuestions() {
		String[][] twoDimQuestionArray = this.questions.getArray();
		this.questionArray = new Question[twoDimQuestionArray.length];
		for (int i = 0; i < twoDimQuestionArray.length; i++) {
			questionArray[i] = new Question(twoDimQuestionArray[i][0],getAnswers(i, twoDimQuestionArray), twoDimQuestionArray[i][5]);
		}
	}

	public Question[] getQuestionArray() {
		return questionArray;
	}

	private String[] getAnswers(int index, String[][] twoDimQuestionArray) {
		String[] answers = new String[4];
		int indexAnswer = 1;
		for (int i = 0; i < answers.length; i++) {
			answers[i] = twoDimQuestionArray[index][indexAnswer++];
		}
		return answers;
	}
}
