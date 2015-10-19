package netrunner;

public class Cerebral_Imagining extends Corporation{
	
	public Cerebral_Imagining() {
		super();
	}
	
	public void gainCredits(int change) {
		super.gainCredits(change);
		setMaxHandSize(getCredits());
	}

}
