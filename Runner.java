package netrunner;

import java.util.ArrayList; 

class Runner extends Player{
	
	private int tags;
	private int memoryUnits; 
	
	private ArrayList<Card> stack = new ArrayList<>();
	private ArrayList<Card> grip = new ArrayList<>();
	private ArrayList<Card> heap = new ArrayList<>();
	
	public Runner(){
		super(4); 
		tags = 0;
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
	
	public void gainMemoryUnits(int mU){
		if (mU <= 0){
			throw new IllegalArgumentException();
		}
		else {
			memoryUnits += mU;
		}
	}

	public void useMemoryUnits(int mU){
		if(mU <= 0){
			throw new IllegalArgumentException();
		}
		else {
			memoryUnits -= mU; 
			if(memoryUnits < 0){
				throw new java.lang.IllegalArgumentException("You don't have enough memory units to install a card right now!");
			}
		}
	}
	
	public int getMemoryUnits(){
		return memoryUnits; 
	}
	
	
	public Card getLastCardInGrip(){
		return grip.get(grip.size()-1);
	}
	
	public void addFiskInvestmentCardToStack(){
		Card card1 = new Card("Fisk Investment Seminar");
		stack.add(card1);
	}
	
	public Card getTopCardFromStack(){
		return stack.get(0); 
	}
	
	public int getAmountOfCardsInGrip(){
		return grip.size();
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
