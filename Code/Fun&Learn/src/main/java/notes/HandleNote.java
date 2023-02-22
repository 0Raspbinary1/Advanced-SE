package main.java.notes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.alles.HandleExit;
import main.java.alles.HandleInput;
import main.java.convert.ConversionType;



public class HandleNote {
	
	private String fileName; 
	private Map<String, String> fileMap;
	private HashMap<String, Object> numberMap = new HashMap<>();
	private HashMap<String, Object> optionMap = new HashMap<>();
	private String text = "Option auswaehlen\n ";
	private InputStream systemIn;
	
	public HandleNote(NotesTypes input, String[] args, InputStream systemIn) {
		this.systemIn = systemIn;
		initiateMaps();
		switch(input) {
			case AUFLISTEN:
				list(args);
				break;
			case NEU:
				createNote();
				break;
		}
		NotesStartSite.main(args);
	}

	private void delete() {
		String pathString = new NoteList().getDir() + File.separator + this.fileName;
		Path path = Paths.get(pathString);
		try {
			if(Files.deleteIfExists(path)) {
				System.out.println("Notiz \"" + this.fileName + "\" geloescht");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void edit() {
//		
//	}
	
	private void createNote() {
		createFile();
		writeInFile();
	}
	
	private void createFile() {
		System.out.println("Bitte den Titel fuer die Notiz eingeben");
		String title = getTitle() + ".txt";
		File file = new File(new NoteList().getDir() + File.separator + title);
		try {
			if(file.createNewFile()) {
				this.fileName = title;
				System.out.println("Notizdatei \"" + this.fileName + "\" erstellt");
			}else {
				System.out.println("Eine Notiz mit diesem Namen existiert bereits ");
				createFile();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getTitle() {
		Scanner sc = new Scanner(this.systemIn);
		String title = sc.nextLine();
		return title;
	}

	private void writeInFile() {
		String noteText = getNoteText();
		try {
			FileWriter writer = new FileWriter(new NoteList().getDir()+ File.separator + this.fileName);
			writer.write(noteText);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		String data = new NoteList().readFile(fileName);
		System.out.println("Die Notiz \"" + fileName + "\" beinhaltet: \n" );
		System.out.println("---------------------------- \n\n\n" + data + " \n\n\n---------------------------- \n");
	}
	
	private void list(String [] args) {
		System.out.println("Eine Liste der erstellten Notizen: " );
		int index = 0;
		for (String name : fileMap.keySet()) {
			numberMap.put(""+ index, name);
			System.out.println(index++ + ": " + name);
		}
		chooseNote(args);
	}
	private void initiateMaps() {
		this.fileMap = new NoteList().getMap();
		inititateOptionMap();
	}
	
	private void inititateOptionMap() {
//		A: Anzeigen\n L: Loeschen\n N: neue Notiz erstellen\n S: zum Start zurueck\n X: Programm beenden";
		StringBuilder textBuilder = new StringBuilder();
		int index = 0;
		for (NotesOptions type : NotesOptions.values()) {
			String stringType = type.toString();
			String stringIndex = ""+ ++index;
			this.optionMap.put(stringIndex, type);
			textBuilder.append(stringIndex + ": "+ stringType + "\n ");
		}
		textBuilder.append("S: Zum Start zurueck \n X: Programm beenden \n...");
		text = textBuilder.toString();
//		this.optionMap.put("A", "show");
//		this.optionMap.put("D", "delete");
//		this.optionMap.put("N", "new");
//		this.optionMap.put("L", "list");
		this.optionMap.put("X", "Exit");
		this.optionMap.put("S", "Start");
	}
	private void chooseNote(String[] args) {
		System.out.println("Bitte den Index der Notiz eingeben: ");
		this.fileName = HandleInput.getInput(this.numberMap, this.systemIn).toString();
		System.out.println("Notiz \"" + this.fileName + "\" ausgewaehlt");
		performOptionOnNote(args);
	}
	
	private void performOptionOnNote(String [] args) {
		System.out.println(text);
		Object input = HandleInput.getInput(optionMap, this.systemIn);
		String inputAsString = input.toString();
		if(inputAsString.equals("Exit") || inputAsString.equals("Start")) {
			HandleExit.perform(inputAsString , args);
		}
		switch((NotesOptions) input) {
		case ZEIGEN:
			show();
			break;
		case LOESCHEN:
			delete();
			break;
		case NEU: 
			createNote();
			break;
		case AUFLISTEN:
			list(args);
			break;
		}
	}
	
	
}
