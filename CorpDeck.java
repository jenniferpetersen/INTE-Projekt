package netrunner;

public class CorpDeck extends Deck {

	
	
	public CorpDeck() {
		super();
		side = "corp";
	}
	
	public void addCard(Card[] card, int idx){
		if(card[idx].getFactionCode().equals("haas-bioroid") ||
			card[idx].getFactionCode().equals("jinteki") ||
			card[idx].getFactionCode().equals("nbn") ||
			card[idx].getFactionCode().equals("weyland") ||
			card[idx].getFactionCode().equals("neutral")){
				getDeckOfCards().add(card[0]);			
			}else{
				throw new IllegalArgumentException("Not a Corp card!");
			}
	}

	
	
	
}