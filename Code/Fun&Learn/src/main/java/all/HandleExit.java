package main.java.all;

public class HandleExit {

	public static void perform(String string, String[] args) {
		switch(string) {
			case "Start":
				FunLearn.main(args);
				break;
			case "Exit":
				System.out.println("Programm wurde beendet");
				System.exit(0);
				break;
			default:
				break;
		}
	}

}
