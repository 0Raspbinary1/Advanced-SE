package convert;

import java.util.Map;

public class Weighting implements ConversionStates{
	public static final Map<String, Number> weights = Map.of("µg", Math.pow(10, -3), "mg", Math.pow(10,-6), "g", Math.pow(10,-3), "kg", 1.0, "t", Math.pow(10,3));
}
