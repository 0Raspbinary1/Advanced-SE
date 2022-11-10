package umrechnen;

import java.util.Map;

public class Temperature implements ConvertationStates {
	public static final Map<String, Number> tempertures = Map.of("kelvin",0.0, "celsius", 0.0, "fahrenheit",0.0);
	public static double convertCelsius(double celsius, String unit) {
		if(unit.equals("kelvin")) {
			return celsius + 273.15;
		}else{
			return celsius * (9/5) + 32;
		}
	}
	
	public static double convertKelvin(double kelvin, String unit) {
		double help = kelvin - 273.15;
		if(unit.equals("celsius")) {
			return help;
		}
		return convertCelsius(help, unit);
		
	}
	
	public static double convertFahrenheit(double fahrenheit, String unit) {
		double help = (fahrenheit - 32) * (5/9);
		System.out.println(help);
		if(unit.equals("celsius")) {
			return help;
		}
		return convertCelsius(help, unit);
	}
}
