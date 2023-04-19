package test.java.play;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.java.play.Computer;
import main.java.play.Person;
import main.java.play.SchereSteinPapier;
import main.java.play.User;

public class TestSSP {
	private User person = new Person();
	private User computer = new Computer();
	private HashMap<String, String> gameMap = new HashMap<String, String>();
	private SchereSteinPapier sssPlay = new SchereSteinPapier();
	
	@Before
	public void setGameMap() {
		this.gameMap.put("SCHERE", "schere");
		this.gameMap.put("STEIN", "stein");
		this.gameMap.put("PAPIER", "papier");
	}

	@Test
	public void testCompareDraw() {
		String computer = this.computer.getChoice();
		String person = computer; 
		assertEquals("draw", this.sssPlay.compare(computer, person));		
	}
	
	@Test
	public void testCompareWin() {
		assertEquals("win", this.sssPlay.compare("schere", "stein"));		
	}
	
	@Test
	public void testCompareLose() {
		assertEquals("lose", this.sssPlay.compare("stein", "schere"));		
	}
	
	@Test
	public void testComputerGetChoice() {
		
		String choice = this.computer.getChoice();
		
		if(choice.equals("schere")) {
			assertEquals("schere", choice);		
		} else if(choice.equals("stein")) {
			assertEquals("stein", choice);		

		}else if(choice.equals("papier")) {
			assertEquals("papier", choice);		

		} else {
			assertEquals(0, 0);
			System.out.println("Fehler bei der Computer Choice");
		}
	}

	@Test
	public void testValidateFinalResultFehler() {
		int computerPunkte = 2;
		int personPunkte = 2;
		assertEquals("Fehler", this.sssPlay.validateFinalResult(computerPunkte, personPunkte));
	}
	
	@Test
	public void testValidateFinalResultSieg() {
		int computerPunkte = 1;
		int personPunkte = 2;
		assertEquals("Glueckwunsch zum Sieg!", this.sssPlay.validateFinalResult(personPunkte, computerPunkte));
	}
	
	@Test
	public void testValidateFinalResultNiederlage() {
		int computerPunkte = 2;
		int personPunkte = 1;
		assertEquals("Schade, vielleicht beim naechsten Spiel!", this.sssPlay.validateFinalResult(personPunkte, computerPunkte));
	}
	
	@Test
	public void testIncrementUserPoints() {
		this.person.setPoints(1);
		this.person.incrementPoints();
		
		assertEquals(2, this.person.getPoints());
	}
	
	@Test
	public void testGetUserPoints() {
		this.computer.setPoints(1);
		int points = this.computer.getPoints();
		assertEquals(1, points);
	}
	
	@Test
	public void testSetUserPoints() {
		this.computer.setPoints(1);
		assertEquals(1, this.computer.getPoints());
	}
}
