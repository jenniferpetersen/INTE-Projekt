package netrunner;

public class CorpDeck extends Deck {

	
	
	public CorpDeck() {
		super();
		side = "corp";
	}
	protected void addCard(Card[] card, int index){
		/*if(card[index].getFactionLetter() == "h" || 
			card[index].getFactionLetter() == "j" || 
			card[index].getFactionLetter() == "w" || 
			card[index].getFactionLetter() == "n"){*/
			super.getDeckOfCards().add(card);	
		//}	
	}
	
	protected int getSize(){
		return super.getDeckOfCards().size();
	}

	
	
	
}