package netrunner;

public class HedgeFund extends Operation{
	
	public HedgeFund(){
		super("HedgeFund", "Transaction", "Gain 9 credits", 5, "neutral", "0", false);
	}
	
	protected void playCard(Corporation corp){
		if (corp.getCredits() >= 5) {
			corp.gainCredits(9);
			corp.removeCardFromHQ(this);
			corp.addCardToArchives(this);
		}
		else {
			throw new IllegalArgumentException("You don't have enough money to play that card!");
		}

	}
	
}
