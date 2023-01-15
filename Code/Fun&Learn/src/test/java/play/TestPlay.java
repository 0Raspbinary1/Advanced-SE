package test.java.play;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.java.alles.HandleInput;
import main.java.play.SchereSteinPapier;

public class TestPlay {
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
	public void testSchereSteinPapierCompareDraw() {
//		this.user = "schere";
//		this.pc = "schere";
//	this.inputStream = new ByteArrayInputStream(user.getBytes());
//		this.response = SchereSteinPapier.compare(this.pc, this.user);
//		assertEquals(response, "1");
		var compare = new SchereSteinPapier();
		assertEquals(1, compare.compare("schere", "schere"));		
	}
	
	@Test
	public void testSchereSteinPapierCompareWin() {
//		this.user = "schere";
//		this.pc = "schere";
//	this.inputStream = new ByteArrayInputStream(user.getBytes());
//		this.response = SchereSteinPapier.compare(this.pc, this.user);
//		assertEquals(response, "1");
		var compare = new SchereSteinPapier();
		assertEquals(2, compare.compare("schere", "stein"));		
	}
	
	@Test
	public void testSchereSteinPapierCompareLose() {
//		this.user = "schere";
//		this.pc = "schere";
//	this.inputStream = new ByteArrayInputStream(user.getBytes());
//		this.response = SchereSteinPapier.compare(this.pc, this.user);
//		assertEquals(response, "1");
		var compare = new SchereSteinPapier();
		assertEquals(0, compare.compare("stein", "schere"));		
	}

}
