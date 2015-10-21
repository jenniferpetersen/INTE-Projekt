package netrunner;

abstract class Operation extends CorpCard{

	public Operation(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness) {
		super(title, "operation", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
	}
	
	abstract void playCard(Corporation corp);
}
