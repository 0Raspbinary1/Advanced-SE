package test.java.notes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.notes.HandleNote;

public class TestNotes {
	private String notesDir = "testNotesDir";
	private File dir = new File(notesDir);
	private HandleNote hnote;
	@SuppressWarnings("serial")
	private List<String> fileNames = new ArrayList<>() {{ add("file1"); add("file2"); add("file3"); }};
	
	@Before
	public void setUpFiles () {
		dir.mkdir();
	}
	
	@Before
	public void setHandleNote() {
		this.hnote = new HandleNote(new ByteArrayInputStream(new byte[0]));
		this.hnote.setNoteList(notesDir);
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
	
	@Test
	public void testListNotes() {
		String refString = createMockNotesAndGetRefString();
		System.out.println(refString);
		System.out.println();
		String response = this.hnote.getListAsString();
		for(String fileName : this.fileNames) {
			fileName += ".txt";
			assertContains(response, fileName);
		}
	}

	private String createMockNotesAndGetRefString() {
		Map<String, String> fileMap = new HashMap<String, String>();
		StringBuilder refString = new StringBuilder();
		int index = 0;
		for(String fileName : this.fileNames) {
			this.hnote.createFile(fileName);
			fileMap.put(fileName +".txt", null);
			refString.append(index++ + ": " + fileName + ".txt\n");
		}
		this.hnote.setFileMap(fileMap);
		return refString.toString();
	}
	
	private static void assertContains(String string, String subString) {
	    assertTrue(string.contains(subString));
	}
}
