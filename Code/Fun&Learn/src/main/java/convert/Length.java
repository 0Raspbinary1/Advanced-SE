package main.java.convert;

import java.util.Map;

public class Length implements ConversionStates{
	public static final Map<String, Number>lenghts = Map.of("MM", Math.pow(10, -3),"CM", Math.pow(10, -2), "DM", Math.pow(10, -1), "M", 1.0, "KM", Math.pow(10, 3));
}
