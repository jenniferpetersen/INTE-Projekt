package netrunner;

public class Upgrade extends CorpCard{

	public Upgrade(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost, boolean uniqueness) {
		super(title, "upgrade", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
	}

}
