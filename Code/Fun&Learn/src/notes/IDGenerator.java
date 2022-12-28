package notes;

import java.nio.charset.Charset;
import java.util.Random;

public class IDGenerator {
	public static String generate() {
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String id = new String(array, Charset.forName("UTF-8"));
		return id;
	}
}
