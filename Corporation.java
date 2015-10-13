package saker;

public class Corporation {
	private int clicks;
	private int credits;
	private int agendaPoints;
	private int maxHandSize;
	
	public Corporation() {
		clicks = 3;
		credits = 5;
		agendaPoints = 0;
		maxHandSize = 5;
	}
	
	public int getClicks() {
		return clicks;
	}
	
	public void changeClicks() {
		clicks -= 1;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void gainCredits(int change) {
		credits += change;
	}

	public void loseCredits(int change) {
		credits -= change;
	}
	
	public void addAgendaPoints(int agendaPoints) {
		if (agendaPoints < 0) {
			throw new IllegalArgumentException();
		}
		
		else {
			this.agendaPoints += agendaPoints;
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
