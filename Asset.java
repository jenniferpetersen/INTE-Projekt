package netrunner;

abstract class Asset extends CorpCard{
	
	private int trashCost;
	private boolean rezzed;

	public Asset(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness, int trashCost) {
		super(title, "asset", subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		this.trashCost = trashCost;
		rezzed = false;
	}
	
	abstract void installCard(Corporation corp);
	abstract void trashCard(Runner runner, Corporation corp);
	abstract void rezCard();
	
	public int getTrashCost() {
		return trashCost;
	}
	
	public boolean isRezzed() {
		return rezzed;
	}
	
	public void setRezzed(boolean rezzed) {
		this.rezzed = rezzed;
	}

}
