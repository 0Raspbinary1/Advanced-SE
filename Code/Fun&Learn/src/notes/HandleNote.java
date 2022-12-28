package notes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import alles.HandleExit;
import alles.HandleInput;


public class HandleNote {
	
	private String fileName; 
	private Map<String, String> fileMap;
	private HashMap<String, String> numberMap = new HashMap<>();
	private HashMap<String, String> optionMap = new HashMap<>();
	private String text = "Option auswählen\n A: Anzeigen\n L: Loeschen\n N: neue Notiz erstellen\n S: zum Start zurück\n X: Programm beenden";
	
	public HandleNote(String type, String[] args) {
		initiateMaps();
		switch(type) {
			case "list":
				list(args);
				break;
			case "new":
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
				System.out.println("Notiz \"" + this.fileName + "\" gelöscht");
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
		System.out.println("Bitte den Titel für die Notiz eingeben");
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
		Scanner sc = new Scanner(System.in);
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
		Scanner sc = new Scanner(System.in);
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
		this.optionMap.put("A", "show");
		this.optionMap.put("L", "delete");
		this.optionMap.put("N", "new");
		this.optionMap.put("X", "Exit");
		this.optionMap.put("S", "Start");
	}
	private void chooseNote(String[] args) {
		System.out.println("Bitte den Index der Notiz eingeben: ");
		this.fileName = this.numberMap.get(HandleInput.getInput(this.numberMap));
		System.out.println("Notiz \"" + this.fileName + "\" ausgewählt");
		performOptionOnNote(args);
	}
	
	private void performOptionOnNote(String [] args) {
		System.out.println(text);
		String input = this.optionMap.get(HandleInput.getInput(optionMap));
		if(input.equals("Exit") || input.equals("Start")) {
			HandleExit.perform(input , args);
		}
		switch(input) {
		case "show":
			show();
			break;
		case "delete":
			delete();
			break;
		case "new": 
			createNote();
			break;
		}	
	}
	
	
}
