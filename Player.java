package netrunner;

import java.util.ArrayList;

abstract class Player {
	private int clicks;
	private int credits;
	private int agendaPoints;
	private int maxHandSize;
	
	private boolean winner; 
	private boolean turnOver;
	private boolean loser;
	
	private ArrayList<Agenda> scoreArea = new ArrayList<>();
	
	public Player(int clicks) {
		this.clicks = clicks;
		credits = 5;
		agendaPoints = 0;
		maxHandSize = 5;
		
		winner = false;
		setLoser(false);
		turnOver = false;
	}
	
	abstract void drawCard();
	
	public void addToScoreArea(Agenda agenda) {
		scoreArea.add(agenda);
		addAgendaPoints(agenda.getAgendaPoints());
	}
	
	public boolean isInScoreArea(Agenda a) {
		return scoreArea.contains(a);
	}
	
	public void useClick() {
		if (clicks > 0) {
			clicks -= 1;
			if (clicks == 0) {
				turnOver = true;
			}
		}
		else {
			throw new java.lang.IllegalArgumentException();	//battre exception?
		}

	}	
	public int getClicks() {
		return clicks;
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
		if (change <= 0) {
			throw new IllegalArgumentException();
		}
		else {
			credits += change;
		}
	}

	public void loseCredits(int change) {
		if (change <= 0) {
			throw new IllegalArgumentException();
		}
		else {
			if (credits - change < 0) {
				throw new java.lang.IllegalArgumentException("You cannot afford to spend that many credits!");
			}
			else{
				credits -= change;
			}
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

	public boolean isLoser() {
		return loser;
	}

	public void setLoser(boolean loser) {
		this.loser = loser;
	}
}
