package Umrechnen;

import java.util.Scanner;

public class Ma�e {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double ma�;
		System.out.println("\n\nMa�e ausrechnen: \n\n\n"
				+ "1: mg zu g"
				+ "2: g zu mg"
				+ "3: g zu kg"
				+ "4: kg zu g"
				+ "5: kg zu t"
				+ "6: t zu kg");
		ma� = sc.nextInt();
		if(ma� == 1) {
			double mg;
			mg = sc.nextInt();
			double erg = mg / 1000;
			System.out.println("Ergebnis: "+erg);
		}
	}

}
