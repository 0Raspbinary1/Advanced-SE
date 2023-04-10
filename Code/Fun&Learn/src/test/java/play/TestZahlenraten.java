package test.java.play;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.java.alles.HandleInput;
import main.java.play.SchereSteinPapier;
import main.java.play.Zahlenraten;

public class TestZahlenraten {

	private Zahlenraten raten = new Zahlenraten(System.in);


	@Test
	public void testGetEingabe() {
		this.raten.setEingabe(13);
		assertEquals(13, this.raten.getEingabe());
	}
	
	@Test
	public void testCreateRandomNumber() {
//		should be >=min && <= MAX
		boolean passt = false;
		int up1 = 20;
		int down1 = 0;
		Zahlenraten raten = new Zahlenraten(System.in);
		int random = raten.createRandomNumber(down1, up1);
		
		if(random <= up1 && random >= down1) {
			passt = true;
			assertEquals(true, passt);
		} else {
			assertEquals(false, passt);	
		}
		
	}
	
	@Test
	public void testGuessTheNumberGefunden() {
		int min = 0;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(13);
		
		assertEquals("gefunden", this.raten.guessTheNumber(min, max, rand));
	}
	
	@Test
	public void testGuessTheNumberGroesser() {
		int min = 0;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(10);
		
		assertEquals("groesser", this.raten.guessTheNumber(min, max, rand));
	}
	
	@Test
	public void testGuessTheNumberKleiner() {
		int min = 0;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(15);
		
		assertEquals("kleiner", this.raten.guessTheNumber(min, max, rand));
	}
	
	@Test
	public void testGuessTheNumberGefundenUngueltig() {
		int min = 1;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(0);
		assertEquals("ungueltig", this.raten.guessTheNumber(min, max, rand));
		
		
		min = 1;
		max = 20;
		rand = 13;
		
		this.raten.setEingabe(21);
		assertEquals("ungueltig", this.raten.guessTheNumber(min, max, rand));
	}
	
	@Test
	public void testGuessTheNumberSetEingabe() {
		int num = 0;
		this.raten.setEingabe(num);
		assertEquals(0, this.raten.eingabe);
	}

	@Test
	public void testGuessTheNumberGetEingabe() {
		this.raten.setEingabe(4);
		assertEquals(4, this.raten.getEingabe());
	}
	
//	@Test
//	public void testGuessTheNumberReadInteger() {
//		int num = 5;
//		this.raten.readInteger(this.inputStream.read(5));
//	}
	
	

	
	
//	@Test
//	public void testsetRangeDown() {
//		String input = "42\n"; // Die Eingabe, die der Scanner lesen soll
//		System.setIn(new ByteArrayInputStream(input.getBytes()));
//		Zahlenraten myClass = new Zahlenraten(this.inputStream);
//		int result = myClass.readInteger();
//		
//	}
		

}
