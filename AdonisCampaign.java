package netrunner;

import java.util.ArrayList;

public class AdonisCampaign extends Asset{
	
	public AdonisCampaign() {
		super("Adonis Campaign", "Advertisement", "Put 12 from the bank on Adonis Campaign when rezzed. When there are no credits left on Adonis Campaign, trash it."
				+ "Take 3 from Adonis Campaign when your turn begins.", 4, "Haas-Bioroid", "2", false, 3);
	}

	protected void installCard(Corporation corp) {
		corp.removeCardFromHQ(this);
		corp.installAsset(this);	
	}
	
	protected void trashCard(Runner runner, Corporation corp) {  
		if (runner.getCredits() >= getTrashCost()) {
			corp.removeCardFromHQ(this);
			corp.removeCardFromRD(this); //ta in ArrayList som parameter istället och ta bort direkt? En av dessa rader är onödig
		}
	}
}
