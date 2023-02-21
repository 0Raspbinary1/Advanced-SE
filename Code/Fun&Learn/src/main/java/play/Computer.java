package main.java.play;

public class Computer implements User {

	private int points;
	
	@Override
	public String getChoice() {
		String[] arr = new String[] { "schere", "stein", "papier" };
		String randChoice = "";
		int rand = 0 + (int) (Math.random() * ((2 - 0) + 1));
		randChoice = arr[rand];
		return randChoice;		
	}

	@Override
	public void incrementUserPoints() {
		this.points++;
	}

	@Override
	public int getUserPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}

}
