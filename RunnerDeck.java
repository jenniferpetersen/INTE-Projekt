package netrunner;

public class RunnerDeck extends Deck {

	public RunnerDeck() {
		super();
		side = "runner";
	}
	
	public void addCard(Card[] runnerCard, int idx){
		if(runnerCard[idx].getFactionCode().equals("anarch")||
			runnerCard[idx].getFactionCode().equals("criminal") ||
			runnerCard[idx].getFactionCode().equals("shaper") ||
			runnerCard[idx].getFactionCode().equals("neutral")){
				getDeckOfCards().add(runnerCard[0]);
			}else{
				throw new IllegalArgumentException("Not a Runner card!");
			}
	}
	
}