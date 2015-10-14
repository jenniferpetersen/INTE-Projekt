public class HedgeFund {
	
	private int cost; 
	private String type; 
	 
	
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
	
	public int gainCredits(int credits){
		credits += 9; 
		return credits; 
	}
	
}
