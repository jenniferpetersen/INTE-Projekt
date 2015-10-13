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

}
