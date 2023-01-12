package main.java.convert;

import java.util.Map;

public class Time implements ConversionStates {
	public static final Map<String, Number> times = Map.of("MS", Math.pow((1.0/60), 2)*Math.pow(10, -3),"S", Math.pow((1.0/60),2) ,"MIN", (1.0/60) ,"H", 1.0 ,"T", 24.0);
}
