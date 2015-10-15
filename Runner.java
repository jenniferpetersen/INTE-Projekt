package netrunner;

import java.util.ArrayList; 

class Runner extends Player{
	
	private ArrayList<Card> stack = new ArrayList<>();
	private ArrayList<Card> grip = new ArrayList<>();
	private ArrayList<Card> heap = new ArrayList<>();
	
	public Runner(){
		super(4); 
	}
	
	public void addFiskInvestmentCardToStack(){
		Card card1 = new Card("Fisk Investment Seminar", "event", "Priority", "Play only as your first [Click].\r\nEach player draws 3 cards.", 0, "Criminal", "criminal", "c", "2",
				false);
		stack.add(card1);
	}
	
	public Card getTopCardFromStack(){
		return stack.get(0); 
	}
	
	public boolean isStackEmpty() {
		return stack.isEmpty();
	}
	
	public void drawCard(){
		if(stack.size() > 0) {
			grip.add(getTopCardFromStack());
			stack.remove(getTopCardFromStack());
		}else{
			
		}
	}


}
