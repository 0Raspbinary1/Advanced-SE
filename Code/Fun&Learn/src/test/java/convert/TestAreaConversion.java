package test.java.convert;

import static org.junit.Assert.assertEquals;

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
		this.conv.setSystemIn(null);
		this.conv.setUnit("qm");
		this.conv.setInputNumber(1);
		this.conv.setGoalUnit("qkm");
		this.conv.perform(new String[0]);
		assertEquals(this.conv.getOutput(), 0);
	}
}
