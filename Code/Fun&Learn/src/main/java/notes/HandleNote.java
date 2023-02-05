package main.java.notes;

import java.awt.Desktop;
import java.awt.desktop.QuitEvent;
import java.awt.desktop.QuitHandler;
import java.awt.desktop.QuitResponse;
import java.awt.desktop.QuitStrategy;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.alles.HandleExit;
import main.java.alles.HandleInput;

public class HandleNote {

	private String fileName;
	private Map<String, String> fileMap;
	private HashMap<String, String> numberMap = new HashMap<>();
	private HashMap<String, String> optionMap = new HashMap<>();
	private String text = "Option auswaehlen\n A: Anzeigen\n L: Loeschen\n E: Bearbeiten\n N: neue Notiz erstellen\n S: zum Start zurueck\n X: Programm beenden";
	private InputStream systemIn;
	private NoteList noteList = new NoteList();
	private String dir = System.getProperty("user.home") + File.separator + "Documents" + File.separator
			+ "Notes by Fun&Learn";

	public HandleNote(InputStream systemIn) {
		this.systemIn = systemIn;
		this.inititateOptionMap();
	}

	public void setNoteList(String dir) {
		this.noteList.setDir(dir);
	}

	public void setFileMap(Map<String, String> fileMap) {
		this.fileMap = fileMap;
	}

	public void perform(String type, String[] args) {
		this.setNoteList(this.dir);
		this.fileMap = this.noteList.getMap();
		switch (type) {
		case "list":
			list();
			chooseNote(args);
			break;
		case "new":
			createNote();
			break;
		}
		NotesStartSite.main(args);
	}

	public void setSystemIn(InputStream systemIn) {
		this.systemIn = systemIn;
	}

	public void delete() {
		String pathString = this.noteList.getDir() + File.separator + this.fileName;
		Path path = Paths.get(pathString);
		try {
			if (Files.deleteIfExists(path) && this.systemIn instanceof BufferedInputStream) {
				System.out.println("Notiz \"" + this.fileName + "\" geloescht");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void edit() {
		System.err.println(
				"Zum Editieren der Notiz diese bitte im Editor speichern, erst dann kann das Programm weiter ausgefuehrt werden.");
		Desktop desk = Desktop.getDesktop();
		File file = new File(this.noteList.getDir() + File.separator + this.fileName);
		try {
			desk.edit(file);
			boolean saved = false;
			LocalDateTime now = LocalDateTime.now();
			while (!saved) {
				LocalDateTime saveTime = LocalDateTime.ofInstant(
						Files.readAttributes(file.toPath(), BasicFileAttributes.class).lastModifiedTime().toInstant(),
						ZoneId.systemDefault());
				if (Duration.between(saveTime, now).toSeconds() < 10) {
					saved = true;
				}
			}
			System.out.println("edited note " + this.fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private void createNote() {
		createFile(getTitle());
		writeInFile(getNoteText());
	}

	public void createFile(String filename) {
		File file = new File(this.noteList.getDir() + File.separator + filename);
		try {
			if (file.createNewFile()) {
				this.fileName = filename;
				if (this.systemIn instanceof BufferedInputStream) {
					System.out.println("Notizdatei \"" + this.fileName + "\" erstellt");
				}
			} else {
				if (this.systemIn instanceof BufferedInputStream) {
					System.out.println("Eine Notiz mit diesem Namen existiert bereits ");
					createFile(getTitle());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getTitle() {
		Scanner sc = new Scanner(this.systemIn);
		String title = sc.nextLine();
		return title + ".txt";
	}

	public void writeInFile(String noteText) {
		try {
			FileWriter writer = new FileWriter(this.noteList.getDir() + File.separator + this.fileName);
			writer.write(noteText);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public NoteList getNoteList() {
		return noteList;
	}

	private String getNoteText() {
		System.out.println("Bitte den Text der Notiz eingeben: ");
		System.err.println("\":wq\" speichert die Notiz und beendet die Eingabe");
		Scanner sc = new Scanner(this.systemIn);
		sc.useDelimiter(":wq");
		String line;
		while (true) {
			line = sc.next();
			break;
		}
		return line;
	}

	private void show() {
		String data = this.noteList.readFile(fileName);
		System.out.println("Die Notiz \"" + fileName + "\" beinhaltet: \n");
		System.out.println("---------------------------- \n\n\n" + data + " \n\n\n---------------------------- \n");
	}

	private void list() {
		System.out.println("Eine Liste der erstellten Notizen: ");
		System.out.println(getListAsString());

	}

	public String getListAsString() {
		StringBuilder list = new StringBuilder();
		int index = 0;
		for (String name : fileMap.keySet()) {
			numberMap.put("" + index, name);
//			System.out.println(index++ + ": " + name + "\n");
			list.append(index++ + ": " + name + "\n");
		}
//		System.out.println(list.toString());
		return list.toString();
	}

//	private void initiateMaps() {
//		
//		inititateOptionMap();
//	}

	private void inititateOptionMap() {
		this.optionMap.put("A", "show");
		this.optionMap.put("D", "delete");
		this.optionMap.put("E", "edit");
		this.optionMap.put("N", "new");
		this.optionMap.put("L", "list");
		this.optionMap.put("X", "Exit");
		this.optionMap.put("S", "Start");
	}

	private void chooseNote(String[] args) {
		System.out.println("Bitte den Index der Notiz eingeben: ");
		this.fileName = HandleInput.getInput(this.numberMap, this.systemIn);
		System.out.println("Notiz \"" + this.fileName + "\" ausgewaehlt");
		performOptionOnNote(args);
	}

	private void performOptionOnNote(String[] args) {
		System.out.println(text);
		String input = HandleInput.getInput(optionMap, this.systemIn);
		if (input.equals("Exit") || input.equals("Start")) {
			HandleExit.perform(input, args);
		}
		switch (input) {
		case "show":
			show();
			break;
		case "delete":
			delete();
			break;
		case "edit":
			edit();
			break;
		case "new":
			createNote();
			break;
		case "list":
			list();
			chooseNote(args);
			break;
		}
	}

}
