package umrechnen;

import java.util.Map;

public class Time implements ConversionStates {
	public static final Map<String, Number> times = Map.of("ms", Math.pow((1.0/60), 2)*Math.pow(10, -3),"s", Math.pow((1.0/60),2) ,"min", (1.0/60) ,"h", 1.0 ,"t", 24.0);
}
