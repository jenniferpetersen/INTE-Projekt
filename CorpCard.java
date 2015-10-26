package netrunner;

abstract class CorpCard extends Card{
	
	private int advancementTokens;
	
	public CorpCard(String title, String typecode, String subTypeCode, String text, int cost,
			String factionCode, String factionCost, boolean uniqueness) {
		super(title, typecode, subTypeCode, text, cost, factionCode, factionCost, uniqueness);
		advancementTokens = 0;
	}

	public int getAdvancementTokens(){
		return advancementTokens;
	}
	
	public void addAdvancementTokens(int advancementTokens){
		if (advancementTokens < 0){
			throw new IllegalArgumentException();
		}
		else{
			this.advancementTokens += advancementTokens;
		}
	}
	
	public void removeAdvancementTokens(int advancementTokens){
		if(advancementTokens <= 0){
			throw new IllegalArgumentException();
		}
		if (this.advancementTokens <= 0){
			throw new IllegalArgumentException();
		}
		else{
			this.advancementTokens -= advancementTokens;
		}
	}
	
	public void buyAdvancementTokens(Corporation corp){
		corp.loseCredits(1);
		addAdvancementTokens(1);
	}
	
	
}
