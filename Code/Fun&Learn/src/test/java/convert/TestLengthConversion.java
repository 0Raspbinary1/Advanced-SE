package test.java.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.convert.Conversion;

public class TestLengthConversion {
	private Conversion conv;

	@Before
	public void setConversion() {
		this.conv = new Conversion("Length", System.in);
	}

	@Test
	public void testMToCm() {
		this.conv.setSystemIn(null);
		this.conv.setUnit("M");
		this.conv.setInputNumber(8.951);
		this.conv.setGoalUnit("CM");
		this.conv.perform(new String[0]);
		assertEquals(8.951 * Math.pow(10, 2), this.conv.getOutput(), Math.pow(10, -5));
	}

	@Test
	public void testMmToM() {
		this.conv.setSystemIn(null);
		this.conv.setGoalUnit("M");
		this.conv.setInputNumber(500.65);
		this.conv.setUnit("MM");
		this.conv.perform(new String[0]);
		assertEquals(500.65 * Math.pow(10, -3), this.conv.getOutput(), Math.pow(10, -4));
	}

	@Test
	public void testQcmToQkm() {
		this.conv.setSystemIn(null);
		this.conv.setGoalUnit("KM");
		this.conv.setInputNumber(25350);
		this.conv.setUnit("DM");
		this.conv.perform(new String[0]);
		assertEquals(25350 * Math.pow(10, -4), this.conv.getOutput(), Math.pow(10, -4));
	}
}
