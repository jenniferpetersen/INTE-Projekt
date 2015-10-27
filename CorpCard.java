package netrunner;

abstract class CorpCard extends Card{
	
	private int advancementTokens;
	
	public CorpCard(String title, String typecode, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness) {
		super(title, typecode, subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		advancementTokens = 0;
	}
	
}