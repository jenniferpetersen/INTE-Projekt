package netrunner;

import java.util.ArrayList;

public class AdonisCampaign extends Asset{
	
	public AdonisCampaign() {
		super("Adonis Campaign", "Advertisement", "Put 12 from the bank on Adonis Campaign when rezzed. When there are no credits left on Adonis Campaign, trash it."
				+ "Take 3 from Adonis Campaign when your turn begins.", 4, "Haas-Bioroid", "2", false, 3);
	}

	protected void installCard(Corporation corp) {	//om ingen remote server skickas med skapas en ny som kortet installeras i
		corp.removeCardFromHQ(this);
		corp.installAssetNewRemote(this);	
	}
	
	protected void installCard(Corporation corp, ArrayList<Card> remote) { //installerar i en redan skapad remote server
		corp.removeCardFromHQ(this);
		corp.installAssetExistingRemote(this, remote);
	}
	
	protected void trashCard(Runner runner, Corporation corp) {  
		if (runner.getCredits() >= getTrashCost()) {
			runner.loseCredits(getTrashCost());
			corp.removeCardFromHQ(this);
			corp.removeCardFromRD(this); //ta in ArrayList som parameter istället och ta bort direkt? En av dessa rader är onödig
										//kortet finns bara i en av dessa, men tas nu bort ur båda.
		}
		else {
			throw new IllegalArgumentException("Not enough credits to trash!");
		}
	}
}
