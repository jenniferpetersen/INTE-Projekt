package netrunner;

import java.util.ArrayList;

class Corporation extends Player{
	
	private ArrayList<Card> researchAndDevelopment = new ArrayList<>();
	private ArrayList<Card> HQ = new ArrayList<>();
	private ArrayList<Card> archives = new ArrayList<>();
	
	public Corporation() {
		super(3);
	}
	
	public void addCardToRD(Card c) {
		researchAndDevelopment.add(c);
	}
	
	public boolean isRDEmpty() {
		return researchAndDevelopment.isEmpty();
	}

	public boolean compareTopCardRD(Card c) {
		return c.equals(researchAndDevelopment.get(0));
	}
	
	public Card getTopCardRD() {
		return researchAndDevelopment.get(0);
	}
	
	public Card getLastCardHQ() {
		return HQ.get(HQ.size()-1);
	}
	
	public boolean compareLastCardHQ(Card c) {
		return c.equals(HQ.get(HQ.size()-1));
	}
	
	public void drawCard() {
		if(researchAndDevelopment.size() > 0) {
			HQ.add(getTopCardRD());
			researchAndDevelopment.remove(getTopCardRD());
		}
		else {
			setLoser(true);
		}
	}
	
	public boolean isCardInHQ(Card c) {
		return HQ.contains(c);
	}
	
	public void trashCardFromHQ(Card c) {
		if(isCardInHQ(c)) {
			archives.add(c);
			HQ.remove(c);
		}
		else {
			throw new java.lang.IllegalArgumentException();
		}
	}
}
	


	
	
