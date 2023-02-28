package test.java.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.convert.Conversion;

public class TestTimeConversion {
	private Conversion conv;

	@Before
	public void setConversion() {
		this.conv = new Conversion("Time", System.in);
		this.conv.setSystemIn(null);
	}

	@Test
	public void testHrToMin() {
		this.conv.setUnit("H");
		this.conv.setInputNumber(8.951);
		this.conv.setGoalUnit("MIN");
		this.conv.perform(new String[0]);
		assertEquals(8.951 * 60, this.conv.getOutput(), Math.pow(10, -5));
	}

	@Test
	public void testMsToHr() {
		this.conv.setGoalUnit("H");
		this.conv.setInputNumber(50086307);
		this.conv.setUnit("MS");
		this.conv.perform(new String[0]);
		assertEquals(13.912863, this.conv.getOutput(), Math.pow(10, -6));
	}

	@Test
	public void testSecToDay() {
		this.conv.setGoalUnit("T");
		this.conv.setInputNumber(2535092);
		this.conv.setUnit("S");
		this.conv.perform(new String[0]);
		assertEquals(29.34134, this.conv.getOutput(), Math.pow(10, -5));
	}
}
