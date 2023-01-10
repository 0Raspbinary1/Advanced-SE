package test.java.all;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.java.alles.HandleInput;

public class TestEntrace {
	 private InputStream inputStream;
	 private String input;
	 private String response;
	 private HashMap<String, String> map = new HashMap();
	 
	 @Before
	 public void setMap() {
			this.map.put("1","Spielen");
			this.map.put("2", "Quiz");
			this.map.put("3", "Notizen");
			this.map.put("4", "Umrechnen");
			this.map.put("X", "Exit");
		}
	// test if goes into the right path of the program in this case convert
	@Test
	public void testOptionConvert() {
		assertTrue(true);
	}
	
	@Test
	public void testHandleInputRightInput() {
		this.input = "test";
		this.inputStream = new ByteArrayInputStream(input.getBytes());
		this.response = HandleInput.getInput(this.map, this.inputStream);
		assertEquals(response, "false input");
	}
	
	@Test
	public void testHandleInputFalseInput() {
		this.input = "x";
		this.inputStream = new ByteArrayInputStream(input.getBytes());
		this.response = HandleInput.getInput(this.map, this.inputStream);
		assertEquals(response, "Exit");
	}
}
