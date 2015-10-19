package netrunner;

public class HedgeFund extends Operation{
	
	public HedgeFund(){
		super("HedgeFund", "Transaction", "Gain 9 credits", 5, "neutral", "0", false);
	}
	
	public void playCard(Cerebral_Imaging corp){
		corp.gainCredits(9);
	}
	
}
