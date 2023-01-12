package test.java.convert;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.java.convert.Conversion;

public class TestAreaConversion {
	private HashMap<String, String> map = new HashMap();
	private String type = "Area";
	private Conversion conv;
	
	@Before
	public void setConversion() {
		this.conv = new Conversion("Area", System.in);
	}
	
	@Test
	public void testQmToQkm() {
		this.conv.perform(new String[0]);
	}
}
