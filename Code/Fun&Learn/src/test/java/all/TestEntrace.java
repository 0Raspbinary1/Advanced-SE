package test.java.all;

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
	 private HashMap<String, Object> map = new HashMap<String, Object>();
	 
	 @Before
	 public void setMap() {
			this.map.put("1","Spielen");
			this.map.put("2", "Quiz");
			this.map.put("3", "Notizen");
			this.map.put("4", "Umrechnen");
			this.map.put("X", "Exit");
		}
	
	@Test
	public void testHandleInputFalseInput() {
		this.input = "test";
		this.inputStream = new ByteArrayInputStream(input.getBytes());
		this.response = HandleInput.getInput(this.map, this.inputStream).toString();
		assertEquals(response, "false input");
	}
	
	@Test
	public void testHandleInputRightInput() {
		this.input = "x";
		this.inputStream = new ByteArrayInputStream(input.getBytes());
		this.response = HandleInput.getInput(this.map, this.inputStream).toString();
		assertEquals(response, "Exit");
	}
}
