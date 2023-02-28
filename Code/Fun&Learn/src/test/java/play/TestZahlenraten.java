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

	private Zahlenraten raten = new Zahlenraten(System.in);;
	private InputStream inputStream;
	private String user;
	private String pc;
	private String response;
	private HashMap<String, String> gameMap = new HashMap<String, String>();

	@Before
	public void setGameMap() {
		this.gameMap.put("SCHERE", "schere");
		this.gameMap.put("STEIN", "stein");
		this.gameMap.put("PAPIER", "papier");
	}

	@Test
	public void testZahlenratenCreateRandomNumber() {
//		should be >=min && <= MAX
		boolean passt = false;
		int up1 = 20;
		int down1 = 0;
		var raten = new Zahlenraten(System.in);
		int random = raten.createRandomNumber(down1, up1);
		
		if(random <= up1 && random >= down1) {
			passt = true;
		}
		assertEquals(true, passt);
	}
	
	@Test
	public void testGuessTheNumberGefunden() {
		int min = 0;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(13);
		
		assertEquals("gefunden", this.raten.guessTheNumber(min, max, rand));
	}//
	
	@Test
	public void testGuessTheNumberGefundenGroesser() {
		int min = 0;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(10);
		
		assertEquals("groesser", this.raten.guessTheNumber(min, max, rand));
	}//
	
	@Test
	public void testGuessTheNumberGefundenKleiner() {
		int min = 0;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(15);
		
		assertEquals("kleiner", this.raten.guessTheNumber(min, max, rand));
	}//
	
	@Test
	public void testGuessTheNumberGefundenUngueltig() {
		int min = 1;
		int max = 20;
		int rand = 13;
		
		this.raten.setEingabe(0);
		assertEquals("ungueltig", this.raten.guessTheNumber(min, max, rand));
		
		//
		
		min = 1;
		max = 20;
		rand = 13;
		
		this.raten.setEingabe(21);
		assertEquals("ungueltig", this.raten.guessTheNumber(min, max, rand));
	}
	

	
	
	
	
	
//	@Test
//	public void testsetRangeDown() {
//		String input = "42\n"; // Die Eingabe, die der Scanner lesen soll
//		System.setIn(new ByteArrayInputStream(input.getBytes()));
//		Zahlenraten myClass = new Zahlenraten(this.inputStream);
//		int result = myClass.readInteger();
//		
//	}
		

}
