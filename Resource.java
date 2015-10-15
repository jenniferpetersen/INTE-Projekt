package netrunner;

public class Resource extends RunnerCard {
	
	public Resource(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost,
			boolean uniqueness) {
		
		
		super(title,"resource", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
		
	}
}
