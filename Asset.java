package netrunner;

abstract class Asset extends CorpCard{
	
	private int trashCost;

	public Asset(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness, int trashCost) {
		super(title, "asset", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		this.trashCost = trashCost;
	}
	
	abstract void installCard(Corporation corp);
	abstract void trashCard(Runner runner, Corporation corp);
	
	public int getTrashCost() {
		return trashCost;
	}

}
