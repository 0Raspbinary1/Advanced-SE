package main.java.notes;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NoteList {
	private String dir = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Notes by Fun&Learn";
	private  HashMap<String, String> notes = new HashMap<>(); //key: filename, value: text in file
	
	public String getDir() {
		return this.dir;
	}

	public  HashMap<String, String> getMap() {
		createDirIfNotExists();
		notes = new HashMap<>();
		try {
			for(String fileName : listFilesUsingDirectoryStream()) {
				String value = readFile(fileName);
				notes.put(fileName, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return notes;
	}
	
	private void createDirIfNotExists() {
		File dir = new File(this.dir);
		if (!dir.exists())
			dir.mkdirs();
	}

	public Set<String> listFilesUsingDirectoryStream() throws IOException {
	    Set<String> fileSet = new HashSet<>();
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
	        for (Path path : stream) {
	            if (!Files.isDirectory(path)) {
	                fileSet.add(path.getFileName()
	                    .toString());
	            }
	        }
	    }
	    return fileSet;
	}
	public String readFile(String name) {
		String data = "";
		try {
			data = new String(Files.readAllBytes(Paths.get(this.dir+ File.separator + name)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
