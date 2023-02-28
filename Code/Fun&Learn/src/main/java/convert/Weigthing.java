package main.java.convert;

import java.util.Map;

public class Weigthing implements ConversionStates{
	public static final Map<String, Number> weigths = Map.of("MUEG", Math.pow(10, -6), "MG", Math.pow(10,-3), "G", 1.0 , "KG", Math.pow(10, 3), "T", Math.pow(10, 6));
}
