package netrunner;

public class Asset extends CorpCard{

	public Asset(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost, boolean uniqueness) {
		super(title, "asset", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
	}

}
