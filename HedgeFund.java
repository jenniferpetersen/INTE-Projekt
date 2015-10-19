package netrunner;

public class HedgeFund extends Operation{
	
	public HedgeFund(){
		super("HedgeFund", "Transaction", "Gain 9 credits", 5, "neutral", "0", false);
	}
	
	public void playCard(Corporation corp){
		corp.gainCredits(9);
	}
	
}
