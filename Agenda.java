package netrunner;

abstract class Agenda extends CorpCard{

	public Agenda(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost, boolean uniqueness) {
		super(title, "agenda", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
	}

}
