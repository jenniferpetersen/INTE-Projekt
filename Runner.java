package netrunner;

import java.util.ArrayList; 

class Runner extends Player{
	
	private int tags;
	
	private ArrayList<Card> stack = new ArrayList<>();
	private ArrayList<Card> grip = new ArrayList<>();
	private ArrayList<Card> heap = new ArrayList<>();
	
	public Runner(){
		super(4); 
	}
	
	public void addTag(int tags){
		if (tags < 0){
			throw new IllegalArgumentException();
		}
		else{
			this.tags += tags;
		}
	}
	
	public void removeTag(int tags){
		if (this.tags <= 0){
			throw new IllegalArgumentException();
		}
		else{
			this.tags -= tags;
		}
	}
	
	public int getTags(){
		return tags;
	}
	
	public Card getLastCardInGrip(){
		return grip.get(grip.size()-1);
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
			//Lackluster, improve?
			System.out.println("Your stack is empty!");
		}
	
	}

}
