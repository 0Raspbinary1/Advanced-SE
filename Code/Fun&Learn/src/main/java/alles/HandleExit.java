package main.java.alles;

public class HandleExit {

	public static void perform(String string, String[] args) {
		switch(string) {
			case "Start":
				FunLearn.main(args);
				break;
			case "Exit":
				System.exit(0);
				break;
			default:
				break;
		}
	}

}
