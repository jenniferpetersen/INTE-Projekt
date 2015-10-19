package netrunner;

public class Upgrade extends CorpCard{

	public Upgrade(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness) {
		super(title, "upgrade", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
	}

}
