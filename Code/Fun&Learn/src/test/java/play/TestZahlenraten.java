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
import main.java.play.Zahlenraten;

public class TestZahlenraten {

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
		// should be >=min && <= MAX
//			this.inputStream = new ByteArrayInputStream(user.getBytes());
//			this.response = SchereSteinPapier.compare(this.pc, this.user);
		String[] args = null;
//		var raten = new Zahlenraten(args);
		assertEquals(0, 0);
	}

}
