package netrunner;

public class Resource extends RunnerCard {
	
	public Resource(String title, String subTypeCode, String text, int cost, 
			String factionCode, String factionCost,
			boolean uniqueness) {
		
		
		super(title,"resource", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		
	}
}
