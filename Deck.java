package netrunner;

import java.util.ArrayList;

public abstract class Deck {

	public Deck(){
		
	}
	
	private static ArrayList<Card[]> deckOfCards = new ArrayList<>();
	String side;
	
	abstract protected void addCard(Card[] card, int index);

	protected ArrayList<Card[]> getDeckOfCards(){
		return deckOfCards;
	}
	
	protected int getSize() {
		return deckOfCards.size();
	}

	
	
}



