package netrunner;

import java.util.ArrayList; 
import java.util.Random;

class Runner extends Player{
	
	private int tags;
	private int memoryUnits; 
	private ArrayList<Card> stack = new ArrayList<>();
	private ArrayList<Card> grip = new ArrayList<>();
	private ArrayList<Card> heap = new ArrayList<>();
	
	public Runner(){
		super(4); 
		tags = 0;
		memoryUnits = 4;
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
		if(tags <= 0){
			throw new IllegalArgumentException();
		}
		if (this.tags - tags <= 0){
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
		if(this.memoryUnits - mU < 0){
			throw new IllegalArgumentException("You don't have enough memory to play that card!");
		}
		else {
			memoryUnits -= mU; 
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

	public void takeDamage(int damageAmount){
		Random rand = new Random();
		if(damageAmount > grip.size()){
			System.out.println("You have flatlined. Good game, well played!");
			setLoser(true);
		}else{
			for(int i = 0; i < damageAmount; i++){
				int idx = rand.nextInt(grip.size());
				grip.remove(idx);
			}
		}
	}
}
