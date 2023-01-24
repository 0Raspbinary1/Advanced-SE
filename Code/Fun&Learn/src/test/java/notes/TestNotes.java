package test.java.notes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.notes.HandleNote;

public class TestNotes {
	private File dir = new File("testNotesDir");
	private HandleNote hnote;
	
	@Before
	public void setUpFiles () {
		dir.mkdir();
	}
	
	@Before
	public void setHandleNote() {
		this.hnote = new HandleNote(new ByteArrayInputStream(new byte[0]));
		this.hnote.setNoteList("testNotesDir");
	}
	
	@After
	public void deleteDirAndFiles() {
		for (File file: dir.listFiles()) {
			file.delete();
		}
		dir.delete();
	}
	
	@Test
	public void testCreateNote() {
		this.hnote.createFile("test.txt");
		assertTrue(new File(dir.getPath() + File.separator + "test.txt").exists());
		String text = "This is a test that the file could be created \nand it could be written in two lines.";
		this.hnote.writeInFile(text);
		assertEquals(text, this.hnote.getNoteList().readFile("test.txt"));
	}
}
