package netrunner;

public class CorpDeck extends Deck {

	
	
	public CorpDeck() {
		super();
		side = "corp";
	}
	
	public void addCard(Card card){
		getDeckOfCards().add(card);
	}

	
	
	
}