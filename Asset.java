package netrunner;

public class Asset extends CorpCard{

	public Asset(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness) {
		super(title, "asset", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
	}

}
