package netrunner;

public class Cerebral_Imaging extends Corporation{
	
	public Cerebral_Imaging() {
		super();
	}
	
	public void gainCredits(int change) {
		super.gainCredits(change);
		setMaxHandSize(getCredits());
	}
	
	public void loseCredits(int change) {
		super.loseCredits(change);
		setMaxHandSize(getCredits());
	}
}
