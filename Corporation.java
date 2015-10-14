package netrunner;

import java.util.ArrayList;

class Corporation extends Player{
	
	private ArrayList<Card> researchAndDevelopment = new ArrayList<>();
	private ArrayList<Card> HQ = new ArrayList<>();
	private ArrayList<Card> archives = new ArrayList<>();
	
	public Corporation() {
		super(3);
	}

	public Card getTopCardRD() {
		return researchAndDevelopment.get(0);
	}
	
	public void drawCard() {
		
	}
}
	


	
	