package saker;

public class Corporation {
	private int clicks;
	private int credits;
	
	public Corporation() {
		clicks = 3;
		credits = 5;
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
}
