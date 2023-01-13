package main.java.quiz;

public class DeutschlandF implements Questions {
	
	@Override
	public String[][] getArray() {
		return de;
	}

	String[][] de;

	public DeutschlandF() {
		initQ();
	}
	
	public void initQ() {
		this.de = new String [9][6];

		this.de[0][0] = "Wie viele Bundeslaender hat Deutschland?";
		this.de[0][1] = "14";
		this.de[0][2] = "15";
		this.de[0][3] = "16";
		this.de[0][4] = "17";
		this.de[0][5] = "c";
		this.de[1][0] = "Wie heisst der/die aktuelle Bundeskanzler/-in? (Stand 2022)";
		this.de[1][1] = "Jennifer Zaminer";
		this.de[1][2] = "Juergen von der Lippe";
		this.de[1][3] = "Olaf Scholz";
		this.de[1][4] = "Angela Merkel";
		this.de[1][5] = "c";
		this.de[2][0] = "Wie viele Einwohner hat Deutschland? (Stand 2022)";
		this.de[2][1] = "80 Mio.";
		this.de[2][2] = "90 Mio.";
		this.de[2][3] = "88 Mio.";
		this.de[2][4] = "84 Mio.";
		this.de[2][5] = "d";
		this.de[3][0] = "Wie heisst die Hauptstadt von Deutschland?";
		this.de[3][1] = "Berlin";
		this.de[3][2] = "Karlsruhe";
		this.de[3][3] = "Frankfurt";
		this.de[3][4] = "Muenchen";
		this.de[3][5] = "a";
		this.de[4][0] = "Welchen Zusatz traegt das Land Sachsen im Namen?";
		this.de[4][1] = "Koenigreich";
		this.de[4][2] = "Keinen";
		this.de[4][3] = "Republik";
		this.de[4][4] = "Freistaat";
		this.de[4][5] = "d";
		this.de[5][0] = "Wie viele Touristen komme jaehrlich nach Berlin?";
		this.de[5][1] = "4 Mio.";
		this.de[5][2] = "14 Mio.";
		this.de[5][3] = "8,5 Mio.";
		this.de[5][4] = "16 Mio.";
		this.de[5][5] = "b";
		this.de[6][0] = "Welche Fluesse fliessen am Deutschen Eck in Rheinland-Pfalz zusammen?";
		this.de[6][1] = "Rhein und Lahn";
		this.de[6][2] = "Rhein und Mosel";
		this.de[6][3] = "Neckar und Donau";
		this.de[6][4] = "Neckar und Rhein";
		this.de[6][5] = "b";
		this.de[7][0] = "Wie viel Ladung geht im Hamburger Hafen im Jahr ueber die Kaikanten?";
		this.de[7][1] = "136,6 Mio. Tonnen";
		this.de[7][2] = "20 Mio. Tonnen";
		this.de[7][3] = "176 Mio. Tonnen";
		this.de[7][4] = "4 Mio. Tonnen";
		this.de[7][5] = "a";
		this.de[8][0] = "Welche internationale Organisation hat ihren Sitz in Hessen?";
		this.de[8][1] = "Europaeische Atomgemeinschaft";
		this.de[8][2] = "UN-Fluechtlingshilfswerk";
		this.de[8][3] = "Europaeische Weltraumorganisation";
		this.de[8][4] = "Europaeische Zentralbank";
		this.de[8][5] = "d";
	}
	
}
