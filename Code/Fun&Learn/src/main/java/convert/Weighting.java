package main.java.convert;

import java.util.Map;

public class Weighting implements ConversionStates{
	public static final Map<String, Number> weights = Map.of("MUEG", Math.pow(10, -3), "MG", Math.pow(10,-6), "G", Math.pow(10,-3), "KG", 1.0, "T", Math.pow(10,3));
}
