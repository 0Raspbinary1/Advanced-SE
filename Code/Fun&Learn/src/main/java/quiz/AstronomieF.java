package main.java.quiz;

public class AstronomieF implements Questions{

	String[][] as;

	public AstronomieF() {
		initQ();
	}

	public String[][] getArray() {
		return as;
	}

	public void initQ() {
		this.as = new String[6][6];

		this.as[0][0] = "Die Sonne ist ein...";
		this.as[0][1] = "Stern";
		this.as[0][2] = "Planet";
		this.as[0][3] = "Komet";
		this.as[0][4] = "Meteor";
		this.as[0][5] = "a";
		this.as[1][0] = "Wie viele Tage dauert es, bis der Merkur die Sonne einmal umkreist hat? ";
		this.as[1][1] = "88";
		this.as[1][2] = "11";
		this.as[1][3] = "33";
		this.as[1][4] = "222";
		this.as[1][5] = "a";
		this.as[2][0] = "Wie alt ist das Universum?";
		this.as[2][1] = "827 Mio. Jahre";
		this.as[2][2] = "6,9 Mrd. Jahre";
		this.as[2][3] = "13,7 Mrd. Jahre";
		this.as[2][4] = "2,1 Bn. Jahre";
		this.as[2][5] = "c";
		this.as[3][0] = "Wie lautet die Reihenfolge der Planeten von der Sonne ausgehend?";
		this.as[3][1] = "Mars, Venus, Erde, Merkur, Jupiter, Saturn, Neptun, Uranus";
		this.as[3][2] = "Merkur, Venus, Erde, Mars, Jupiter, Saturn, Uranus, Neptun";
		this.as[3][3] = "Jupiter, Neptun, Mars, Venus, Erde, Merkur, Uranus, Saturn";
		this.as[3][4] = "Uranus, Merkur, Venus, Jupiter, Erde, Mars, Saturn, Neptun";
		this.as[3][5] = "b";
		this.as[4][0] = "Wie weit etwa ist die Erde von der Sonne entfernt?";
		this.as[4][1] = "21 Millionen Kilometer";
		this.as[4][2] = "150 Millionen Kilometer";
		this.as[4][3] = "730 Millionen Kilometer";
		this.as[4][4] = "2,3 Milliarden Kilometer";
		this.as[4][5] = "b";
		this.as[5][0] = "Wie viel Zeit benoetigt das Licht fuer die Reise von der Sonne zur Erde?";
		this.as[5][1] = "1 Minute und 7 Sekunden";
		this.as[5][2] = "8 Minuten und 19 Sekunden";
		this.as[5][3] = "39 Minuten und 8 Sekunden";
		this.as[5][4] = "2 Stunden und 47 Minuten";
		this.as[5][5] = "b";
	}

}