package netrunner;
import java.util.ArrayList; 

class Runner extends Player{
	
	private ArrayList<Card> stack = new ArrayList<>();
	private ArrayList<Card> grip = new ArrayList<>();
	private ArrayList<Card> heap = new ArrayList<>();
	
	public Runner(){
		super(4); 
	}
	
	public Card getTopCardFromStack(){
		return stack.get(0); 
	}
	
	public void drawCard(){
		
	}


}
