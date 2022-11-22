package Umrechnen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int erg;
		System.out.println("Was willst du umrechnen? \n\n"
				+ "1: Maﬂe\n"
				+ "2: Gewichte");
		erg = sc.nextInt();
		
		if (erg == 1) {
			Maﬂe.main(args);
		}
		
	}

}
