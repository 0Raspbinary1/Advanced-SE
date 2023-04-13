package main.java.play;

public class Computer implements User {

	private int points;
	
	public Computer() {
		this.points = 0;
	}
	
	@Override
	public String getChoice() {
		String[] arr = new String[] { "schere", "stein", "papier" };
		int rand = (int) (Math.random() * ((2 - 0) + 1));
		String randChoice = arr[rand];
		return randChoice;		
	}

	@Override
	public void incrementPoints() {
		this.points++;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;		
	}

}
