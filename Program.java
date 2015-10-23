package netrunner;

abstract class Program extends RunnerCard{
	
	public Program(String title, String subTypeCode, String text, int cost, 
			String factionCode, String factionCost,
			boolean uniqueness) {
		
		
		super(title,"program", subTypeCode, text, cost,  factionCode,  factionCost, uniqueness);
		
	}

}
