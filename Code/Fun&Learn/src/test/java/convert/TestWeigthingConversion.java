package test.java.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.convert.Conversion;

public class TestWeigthingConversion {
	private Conversion conv;

	@Before
	public void setConversion() {
		this.conv = new Conversion("Weigthing", System.in);
		this.conv.setSystemIn(null);
	}

	@Test
	public void testMueggrToKg() {
		this.conv.setUnit("MUEG");
		this.conv.setInputNumber(895593471.64);
		this.conv.setGoalUnit("KG");
		this.conv.perform(new String[0]);
		assertEquals(895593471.64 * Math.pow(10, -9), this.conv.getOutput(), Math.pow(10, -10));
	}

	@Test
	public void testMgToGr() {
		this.conv.setGoalUnit("G");
		this.conv.setInputNumber(50863.07);
		this.conv.setUnit("MG");
		this.conv.perform(new String[0]);
		assertEquals(50863.07 * Math.pow(10, -3), this.conv.getOutput(), Math.pow(10, -6));
	}

	@Test
	public void testGrToTons() {
		this.conv.setGoalUnit("T");
		this.conv.setInputNumber(235092.6);
		this.conv.setUnit("G");
		this.conv.perform(new String[0]);
		assertEquals(235092.6 * Math.pow(10, -6), this.conv.getOutput(), Math.pow(10, -5));
	}
}
