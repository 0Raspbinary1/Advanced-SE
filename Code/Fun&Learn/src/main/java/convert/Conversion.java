package main.java.convert;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import main.java.all.HandleInput;

public class Conversion {
	
	private Scanner sc;
	private Map<String, Number> map = new HashMap<>();
	@SuppressWarnings("serial")
	private List<String> defaultUnits = new ArrayList<>() {{add("kg"); add("m"); add("celsius"); add("qm"); add("h");}};
	private String unit;
	private double inputNumber;
	private String goalUnit;
	private String type;
	private InputStream systemIn;
	private double output;
	
	public Conversion(String type, InputStream systemIn){
		this.map = this.setMap(type);
		this.type = type;
		this.systemIn = systemIn;
		this.setupScanner();
	}
	
	private void setupScanner() {
		this.sc = new Scanner(this.systemIn);
	}

	public void perform(String [] args) {
		if(this.systemIn instanceof BufferedInputStream) {
			this.askForInputs();
		}
		if(this.type.equals("Temperature")) {
			this.output = convertTemperture();
		}else {
			this.output = this.convert();
		}
		if(this.systemIn instanceof BufferedInputStream) {
			System.out.println("\nErgebnis:\n-------------------------\n" + this.output +"\n-------------------------\n");
			ConversionStartSite.main(args);
		} 
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
		System.out.println("Bitte die Einheit des umzurechnenden Werts eingeben: ");
		setUnit(HandleInput.getInput(this.parseMap(), this.systemIn, true));
		System.out.println("Bitte den Wert zum umrechnen eingeben:");
		this.inputNumber = readDoubleInput();
		System.out.println("Bitte die Einheit eingeben, in die umgerechnet werden soll: ");
		setGoalUnit(HandleInput.getInput(this.parseMap(), systemIn, true));
	}

	public double getOutput() {
		return output;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setInputNumber(double inputNumber) {
		this.inputNumber = inputNumber;
	}

	public void setGoalUnit(String goalUnit) {
		this.goalUnit = goalUnit;
	}

	public void setSystemIn(InputStream systemIn) {
		this.systemIn = systemIn;
	}

	private HashMap<String, String> parseMap() {
		HashMap stringMap = new HashMap();
		Set<String> keys = this.map.keySet();
 		for (String key:keys) {
 			stringMap.put(key, this.map.get(key).toString());
 		}
		return stringMap;
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

