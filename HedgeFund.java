public class HedgeFund {
	
	private int cost; 
	private String type; 
	private String text; 
	 
	
	public HedgeFund(){
		cost = 5;
		type = "Operation";
	}
	
	public int getCost(){
		return cost; 
	}
	
	public String getType(){
		return type; 
	}
	
	public String getText(){
		return text; 
	}
	
	public int gainCredits(int credits){
		credits += 9; 
		return credits; 
	}
	
}
