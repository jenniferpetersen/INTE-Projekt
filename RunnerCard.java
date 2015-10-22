package netrunner;


abstract class RunnerCard extends Card{

	public RunnerCard(String title, String typecode, String subTypeCode, String text, int cost,
			 String factionCode, String factionCost,
			boolean uniqueness) {
	
		super(title, typecode, subTypeCode, text, cost, factionCode, factionCost,
				uniqueness);
		
		
	}
	

}
