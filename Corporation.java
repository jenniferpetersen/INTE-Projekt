package saker;

public class Corporation {
	private int clicks;
	
	public Corporation() {
		clicks = 3;
	}
	
	public int getClicks() {
		return clicks;
	}
	
	public void changeClicks() {
		clicks -= 1;
	}

}
