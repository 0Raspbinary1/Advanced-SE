package umrechnen;

import java.util.Map;

public class Area implements ConversionStates {
	public static final Map<String, Number> areas = Map.of("qmm", Math.pow(10, -6),"qcm", Math.pow(10, -4), "qdm", Math.pow(10, -2), "qm", 1.0, "qkm", Math.pow(10, 6));
}
