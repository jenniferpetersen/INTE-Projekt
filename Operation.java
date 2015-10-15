package netrunner;

public class Operation extends CorpCard{

	public Operation(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost, boolean uniqueness) {
		super(title, "operation", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
	}

}
