package test.java.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.convert.Conversion;

public class TestAreaConversion {
	private Conversion conv;
	
	@Before
	public void setConversion() {
		this.conv = new Conversion("Area", System.in);
		this.conv.setSystemIn(null);
	}
	
	@Test
	public void testQmToQkm() {
		this.conv.setUnit("QM");
		this.conv.setInputNumber(13.951);
		this.conv.setGoalUnit("QKM");
		this.conv.perform(new String[0]);
		assertEquals(13.951*Math.pow(10, -6), this.conv.getOutput(), Math.pow(10, -9));
	}
	
	@Test
	public void testQkmToQm() {
		this.conv.setGoalUnit("QM");
		this.conv.setInputNumber(5.65);
		this.conv.setUnit("QKM");
		this.conv.perform(new String[0]);
		assertEquals(5.65*Math.pow(10, 6), this.conv.getOutput(), Math.pow(10, 8));
	}
	
	@Test
	public void testQcmToQkm() {
		this.conv.setGoalUnit("QKM");
		this.conv.setInputNumber(2.5);
		this.conv.setUnit("QCM");
		this.conv.perform(new String[0]);
		assertEquals(2.5*Math.pow(10, -10), this.conv.getOutput(), Math.pow(10, -11));
	}
}
