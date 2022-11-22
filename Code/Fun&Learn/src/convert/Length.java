package convert;

import java.util.Map;

public class Length implements ConversionStates{
	public static final Map<String, Number>lenghts = Map.of("mm", Math.pow(10, -3),"cm", Math.pow(10, -2), "dm", Math.pow(10, -1), "m", 1.0, "km", Math.pow(10, 3));
}
