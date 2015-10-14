package netrunner;

import java.util.ArrayList;

class Corporation extends Player{
	
	private ArrayList<Card> researchAndDevelopment = new ArrayList<>();
	private ArrayList<Card> HQ = new ArrayList<>();
	private ArrayList<Card> archives = new ArrayList<>();
	
	public Corporation() {
		super(3);
		researchAndDevelopment.add(new Card("Noise"));
		researchAndDevelopment.add(new Card("Snare!"));
	}

	public Card getTopCardRD() {
		return researchAndDevelopment.get(0);
	}
	
	public Card getLastCardHQ() {
		return HQ.get(HQ.size()-1);
	}
	
	public void drawCard() {
		HQ.add(getTopCardRD());
		researchAndDevelopment.remove(getTopCardRD());
	}
}
	


	
	
