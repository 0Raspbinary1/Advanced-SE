package main.java.convert;

import java.util.Map;

public class Area implements ConversionStates {
	public static final Map<String, Number> areas = Map.of("QMM", Math.pow(10, -6),"QCM", Math.pow(10, -4), "QDM", Math.pow(10, -2), "QM", 1.0, "QKM", Math.pow(10, 6));
}
