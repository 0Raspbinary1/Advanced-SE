package umrechnen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Convertation {
	
	private Scanner sc =  new Scanner(System.in);
	private Map<String, Number> map = new HashMap<>();
	private List<String> defaultUnits = new ArrayList<>() {{add("kg"); add("m"); add("celsius");}};
	private String unit;
	private double inputNumber;
	private String goalUnit;
	private String type;
	
	public Convertation(String type, String[] args){
		this.map = this.setMap(type);
		this.type = type;
		this.perform(args);
	}
	
	private void perform(String [] args) {
		this.askForInputs();
		double output;
		if(this.type.equals("Temperature")) {
			output = convertTemperture();
		}else {
			output = this.convert();
		}
		System.out.println(output);
		ConvertationStartSite.main(args);
	}
	
	private double convertTemperture() {
		double help;
		if(this.defaultUnits.contains(this.unit)) {
			return Temperature.convertCelsius(this.inputNumber, this.goalUnit);
		}else if(this.unit.equals("kelvin")) {
			return Temperature.convertKelvin(this.inputNumber, this.goalUnit);
		}else{
			return Temperature.convertFahrenheit(this.inputNumber, this.goalUnit);
		}
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
			case "Length": 
				return Length.lenghts;
			case "Temperature":
				return Temperature.tempertures;
		}
		return null;
	}
}

