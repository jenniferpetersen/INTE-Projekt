package netrunner;

public class Program extends RunnerCard{
	
	public Program(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost,
			boolean uniqueness) {
		
		
		super(title,"program", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
		
	}

}
