package test.java.notes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.notes.HandleNote;

public class TestNotes {
	private String fileName = "test.txt";
	private String notesDir = "testNotesDir";
	private File dir = new File(notesDir);
	private HandleNote hnote;
	@SuppressWarnings("serial")
	private List<String> fileNames = new ArrayList<>() {
		{
			add("file1.txt");
			add("file2.txt");
			add("file3.txt");
			add("test.txt");
		}
	};

	@Before
	public void setUpFiles() {
		dir.mkdir();
	}

	@Before
	public void setHandleNote() {
		this.hnote = new HandleNote(new ByteArrayInputStream(new byte[0]));
		this.hnote.setNoteList(notesDir);
	}

	@After
	public void deleteDirAndFiles() {
		for (File file : dir.listFiles()) {
			file.delete();
		}
		dir.delete();
	}

	@Test
	public void testCreateNote() {
		createFile();
	}

	@Test
	public void testListNotes() {
		setFileMap();
		String response = this.hnote.getListAsString();
		for (String fileName : this.fileNames) {
			assertContains(response, fileName);
		}
	}

	@Test
	public void testShowNote() {
		createFile();
		writeInfile();
		assertEquals(this.hnote.getNoteList().readFile(this.fileName), getText());

	}

	@Test
	public void testDeleteNote() throws IOException {
		createFiles();
		this.hnote.setFileName(this.fileName);
		this.hnote.delete();
		Set<String> response = this.hnote.getNoteList().listFilesUsingDirectoryStream();
		assertFalse(response.contains(this.fileName));
	}

	private void createFiles() {
		for (String fileName : fileNames)
			try {
				new File(dir.getPath() + File.separator + fileName).createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private void writeInfile() {
		String text = getText();
		this.hnote.writeInFile(text);
	}

	public String getText() {
		return "This is a test that the file could be created \nand it could be written in two lines.";
	}

	private void createFile() {
		this.hnote.createFile(this.fileName);
		assertTrue(new File(dir.getPath() + File.separator + this.fileName).exists());
	}

	private void setFileMap() {
		Map<String, String> fileMap = new HashMap<String, String>();
		for (String fileName : this.fileNames) {
			fileMap.put(fileName, null);
		}
		this.hnote.setFileMap(fileMap);
	}

	private static void assertContains(String string, String subString) {
		assertTrue(string.contains(subString));
	}
}
