package test.java.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.convert.Conversion;

public class TestTemperatureConversion {
	private Conversion conv;

	@Before
	public void setConversion() {
		this.conv = new Conversion("Temperature", System.in);
	}

	@Test
	public void testKelvinToCelsius() {
		this.conv.setSystemIn(null);
		this.conv.setUnit("KELVIN");
		this.conv.setInputNumber(293.15);
		this.conv.setGoalUnit("CELSIUS");
		this.conv.perform(new String[0]);
		assertEquals(20, this.conv.getOutput(), 0.1);
	}

	@Test
	public void testCelsiusToFahrenheit() {
		this.conv.setSystemIn(null);
		this.conv.setGoalUnit("FAHRENHEIT");
		this.conv.setInputNumber(50.65);
		this.conv.setUnit("CELSIUS");
		this.conv.perform(new String[0]);
		assertEquals(123.17, this.conv.getOutput(), 0.01);
	}

	@Test
	public void testFahrenheitToKelvin() {
		this.conv.setSystemIn(null);
		this.conv.setGoalUnit("KELVIN");
		this.conv.setInputNumber(18.47);
		this.conv.setUnit("FAHRENHEIT");
		this.conv.perform(new String[0]);
		assertEquals(265.64, this.conv.getOutput(), 0.01);
	}
}
