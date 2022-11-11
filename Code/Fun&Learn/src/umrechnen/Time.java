package umrechnen;

import java.util.Map;

public class Time implements ConversionStates {
	public static final Map<String, Number> times = Map.of("ms", Math.pow((1/60), 2)*Math.pow(10, -3),"s", Math.pow((1/60),2) ,"m", (1/60) ,"h", 1.0 ,"t", 24);
}
