package main.java.convert;

import java.util.Map;

public class Temperature implements ConversionStates {
	public static final Map<String, Number> temperatures = Map.of("KELVIN",0.0, "CELSIUS", 0.0, "FAHRENHEIT",0.0);
	public static double convertFromCelsius(double celsius, String unit) {
		if(unit.equals("KELVIN")) {
			return celsius + 273.15;
		}else{
			return celsius * (9.0/5) + 32;
		}
	}
	
	public static double convertFromKelvin(double kelvin, String unit) {
		double help = kelvin - 273.15;
		if(unit.equals("CELSIUS")) {
			return help;
		}
		return convertFromCelsius(help, unit);
		
	}
	
	public static double convertFromFahrenheit(double fahrenheit, String unit) {
		double help = (fahrenheit - 32) * (5.0/9);
		if(unit.equals("CELSIUS")) {
			return help;
		}
		return convertFromCelsius(help, unit);
	}
}
