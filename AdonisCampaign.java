package netrunner;

import java.util.ArrayList;

public class AdonisCampaign extends Asset{
	private int credits;
	private ArrayList<Card> installedServer;
	
	public AdonisCampaign() {
		super("Adonis Campaign", "Advertisement", "Put 12 from the bank on Adonis Campaign when rezzed. When there are no credits left on Adonis Campaign, trash it."
				+ "Take 3 from Adonis Campaign when your turn begins.", 4, "Haas-Bioroid", "2", false, 3);
	}

	protected void installCard(Corporation corp) {	//om ingen remote server skickas med skapas en ny som kortet installeras i
		corp.removeCardFromHQ(this);
		installedServer = corp.installCardNewRemote(this);
	}
	
	protected void installCard(Corporation corp, ArrayList<Card> remote) { //installerar i en redan skapad remote server
		corp.removeCardFromHQ(this);
		corp.installCardExistingRemote(this, remote);
		installedServer = remote;
	}
	
	protected void rezCard() {
		credits = 12;
		setRezzed(true);
	}
	
	protected void startOfTurn(Corporation corp) {
		if (isRezzed()) {
			corp.gainCredits(3);
			takeCredits();
			if (credits == 0) {
				trashInstalledCard(corp);
			}
		}
	}
	
	protected void takeCredits() {
		credits -= 3;
	}
	
	protected int getCredits() {
		return credits;
	}
	
	protected ArrayList<Card> getInstalledServer() {
		return installedServer;
	}
	
	protected void trashInstalledCard(Corporation corp) {
		installedServer.remove(this);
		corp.addCardToArchives(this);
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
