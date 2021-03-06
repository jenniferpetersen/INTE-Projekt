package netrunner;

import java.util.ArrayList; 
import java.util.Random;

class Runner extends Player{
	
	private int tags;
	private int memoryUnits; 
	private boolean successfulRun = false;
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
		if(tags <= 0 || this.tags - tags < 0){
			throw new IllegalArgumentException();
		}
		else{
			this.tags -= tags;
		}
	}
	
	public int getTags(){
		return tags;
	}
	
	public void removeTagsForClicks(){
		useClick();
		loseCredits(2);
		removeTag(1);
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
		if(mU <= 0 || this.memoryUnits - mU < 0){
			throw new IllegalArgumentException();
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
		Card card1 = new FiskInvestmentSeminar(); 
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
	
	public boolean isHeapEmpty(){
		return heap.isEmpty();
	}
	
	public void drawCard(){
		if(stack.size() > 0) {
			grip.add(getTopCardFromStack());
			stack.remove(getTopCardFromStack());
		}
	}
	

	public void takeDamage(int damageAmount){
		Random rand = new Random();
		if(damageAmount < 0){
			throw new IllegalArgumentException();
		}
		if(damageAmount > grip.size()){
			setLoser(true);
		}else{
			for(int i = 0; i < damageAmount; i++){
				int idx = rand.nextInt(grip.size());
				trashCardFromGrip(grip.get(idx));
			}
		}
	}
	
	public void trashCardFromGrip(Card c) {
		if(grip.contains(c)){
			heap.add(c);
			grip.remove(c);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public void buyCardForClick(){
		useClick();
		drawCard();
	}
	
	public void buyCreditsForClicks(){
		useClick();
		gainCredits(1);
	}
	
	public boolean wasSuccessfulOnRun(){
		return successfulRun;
	}
	
	public void attemptRun(Corporation corp, String runArea){	
		if(runArea.equalsIgnoreCase("HQ")){
			if(corp.getSizeHQ() == 0){
				throw new IllegalArgumentException("No cards in HQ!"); 
			}else{
				makeSuccessfulRun(corp, runArea);
			}
		}
		if(runArea.equalsIgnoreCase("Archives")){
			if(corp.getSizeArchives() == 0){
				throw new IllegalArgumentException("No cards in Archives!");
			}else{
				makeSuccessfulRun(corp, runArea);
			}
		}
		if(runArea.equalsIgnoreCase("RD")){
			makeSuccessfulRun(corp, runArea);
		}
	}

	public void makeSuccessfulRun(Corporation corp, String runArea){
		useClick();
		successfulRun = true;
		if(runArea.equalsIgnoreCase("HQ")){
			Random rand = new Random();
			int idx = rand.nextInt(corp.getSizeHQ());
			Card c = corp.exposeRandomHQCard(idx);
			if(c instanceof Agenda){
				((Agenda) c).stealAgenda(corp, this, "HQ");	
			}else if(c instanceof Asset){
				((Asset) c).trashCard(this, corp);
			}
			
		}
		if(runArea.equalsIgnoreCase("Archives")){
			ArrayList<Card> cardlist = corp.successfulRunOnArchives();
			for(Card c : cardlist){
				if(c instanceof Agenda){
					((Agenda) c).stealAgenda(corp, this, "Archives");
				}else if(c instanceof Asset){						
					((Asset) c).trashCard(this, corp);
				}
			}
		}
		if(runArea.equalsIgnoreCase("RD")){
			Card rdc = corp.getTopCardRD();
			if(rdc instanceof Agenda){
				((Agenda) rdc).stealAgenda(corp, this, "HQ");	
			}else if(rdc instanceof Asset){
				((Asset) rdc).trashCard(this, corp);
			}
		}
	}
}
