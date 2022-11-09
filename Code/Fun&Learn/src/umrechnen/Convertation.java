package umrechnen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Convertation {
	private Scanner sc =  new Scanner(System.in);
	private Map<String, Number> map = new HashMap<>();
	private List<String> defaultUnits = new ArrayList<>() {{add("kg");}};
	private String unit;
	private double inputNumber;
	private String goalUnit;
	
	public Convertation(String type){
		this.map = this.setMap(type);
		this.perform();
	}
	private void perform() {
		this.askForInputs();
		double output = this.convert();
		System.out.println(output);
	}
	private double convert() {
		double help;
		if(this.defaultUnits.contains(this.unit)) {
			return this.inputNumber / (double) this.map.get(goalUnit);
		}else {
			help = this.inputNumber * (double) this.map.get(unit);
			if(this.defaultUnits.contains(this.goalUnit)) {
				return help;
			}
		}
		return help / (double) this.map.get(goalUnit);
	}
	private void askForInputs() {
		do {
			System.out.println("Bitte die Einheit des umzurechnenden Werts eingeben: ");
			this.unit = sc.nextLine().toLowerCase();
		} while (!this.map.containsKey(this.unit));
		System.out.println("Bitte den Wert zum umrechnen eingeben:");
		this.inputNumber = sc.nextDouble();
		System.out.println("Bitte die Einheit eingeben, in die umgerechnet werden soll: ");
		do {
			this.goalUnit = sc.nextLine().toLowerCase();
		} while (!this.map.containsKey(this.goalUnit));
	}
	private Map<String, Number> setMap(String type) {
		switch (type) {
			case "Weighting":
				return Weighting.weights;
		}
		return null;
	}
	
}
