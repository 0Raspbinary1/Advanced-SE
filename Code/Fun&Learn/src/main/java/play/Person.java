package main.java.play;

import main.java.alles.HandleInput;
import main.java.play.SchereSteinPapier;

public class Person implements User {

	private int points;
	
	@Override
	public String getChoice() {

		return HandleInput.getInput(new SchereSteinPapier().getGameMap(), System.in);		
	}


	@Override
	public void incrementUserPoints() {
		this.points++;		
	}

	@Override
	public int getUserPoints() {
		return this.points;
	}
	
	
	@Override
	public void setUserPoints(int points) {
		this.points = points;
	}
	
}
