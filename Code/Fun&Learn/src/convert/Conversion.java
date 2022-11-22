package convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Conversion {
	
	private Scanner sc =  new Scanner(System.in);
	private Map<String, Number> map = new HashMap<>();
	@SuppressWarnings("serial")
	private List<String> defaultUnits = new ArrayList<>() {{add("kg"); add("m"); add("celsius"); add("qm"); add("h");}};
	private String unit;
	private double inputNumber;
	private String goalUnit;
	private String type;
	
	public Conversion(String type, String[] args){
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
		System.out.println("\nErgebnis:\n-------------------------\n" + output +"\n-------------------------\n");
		ConversionStartSite.main(args);
	}
	
	private double convertTemperture() {
		if(this.defaultUnits.contains(this.unit)) {
			return Temperature.convertFromCelsius(this.inputNumber, this.goalUnit);
		}else if(this.unit.equals("kelvin")) {
			return Temperature.convertFromKelvin(this.inputNumber, this.goalUnit);
		}else{
			return Temperature.convertFromFahrenheit(this.inputNumber, this.goalUnit);
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
		this.inputNumber = readDoubleInput();
		System.out.println("Bitte die Einheit eingeben, in die umgerechnet werden soll: ");
		do {
			this.goalUnit = sc.nextLine().toLowerCase();
		} while (!this.map.containsKey(this.goalUnit));
	}
	
	private double readDoubleInput() {
		while(!sc.hasNextDouble()) {
			System.out.println("Eingabe nicht erkannt. Bitte den Wert zum umrechnen eingeben:");
			sc.next();
		}
		return sc.nextDouble();
	}

	private Map<String, Number> setMap(String type) {
		switch (type) {
			case "Weighting":
				return Weighting.weights;
			case "Length": 
				return Length.lenghts;
			case "Temperature":
				return Temperature.temperatures;
			case "Area":
				return Area.areas;
			case "Time":
				return Time.times;
			default:
				return null;
		}
	}
}

