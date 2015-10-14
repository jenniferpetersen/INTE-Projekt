package saker;

public class Corporation {
	private int clicks;
	private int credits;
	private int agendaPoints;
	private int maxHandSize;
	
	private boolean winner = false;
	private boolean turnOver = false;
	
	public Corporation() {
		clicks = 3;
		credits = 5;
		agendaPoints = 0;
		maxHandSize = 5;
	}
	
	public int getClicks() {
		return clicks;
	}
	
	public void useClick() {
		if (clicks > 0) {
			clicks -= 1;
			if (clicks == 0) {
				turnOver = true;
			}
		}
		else {
			throw new java.lang.IllegalArgumentException();	//bättre exception?
		}

	}
	
	public boolean getWinner() {
		return winner;
	}
	
	public boolean getTurnOver() {
		return turnOver;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void gainCredits(int change) {
		if (credits <= 0) {
			throw new IllegalArgumentException();
		}
		else {
			credits += change;
		}
	}

	public void loseCredits(int change) {
		if (credits <= 0) {
			throw new IllegalArgumentException();
		}
		else {
			credits -= change;
		}
	}
	
	public void addAgendaPoints(int agendaPoints) {
		if (agendaPoints < 0) {
			throw new IllegalArgumentException();
		}
		
		else {
			this.agendaPoints += agendaPoints;
		}
		if (this.agendaPoints >= 7) {
			//VINST!!!!
			winner = true;
		}
	}
	
	public int getAgendaPoints() {
		return agendaPoints;
	}
	
	public void setMaxHandSize(int maxHandSize) {
		if (maxHandSize < 0) {
			throw new IllegalArgumentException();
		}
		
		else {
			this.maxHandSize = maxHandSize;
		}
	}
	
	public int getMaxHandSize() {
		return maxHandSize;
	}
}
