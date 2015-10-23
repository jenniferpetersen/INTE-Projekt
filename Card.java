package netrunner;

abstract class Card {
	private String title;
	private String subTypeCode;
	private String text;
	private int cost;
	private boolean uniqueness;
	private String faction_code; 
	private String factioncost; 
	private String type_code; 
 
	public Card (String title) {
		this.title = title;
		//l�gg till variabler
	}
	
	public Card(String title, String typecode, String subTypeCode,
			String text, int cost, String factionCode, String factionCost, 
			boolean uniqueness) {
		
		this.title = title; 
		this.type_code = typecode;
		this.subTypeCode = subTypeCode;
		this.text = text;
		this.cost = cost;
		this.faction_code = factionCode;
		this.factioncost = factionCost;
		this.uniqueness = uniqueness;

		
	}

	public String getTitle() {
		return title;
	}

	public String getTypeCode() {
		return type_code;
	}


	public String getSubTypeCode() {
		return subTypeCode;
	}


	public String getText() {
		return text;
	}


	public int getCost() {
		return cost;
	}


	public String getFactionCode() {
		return faction_code;
	}


	public String getFactionCost() {
		return factioncost;
	}


	public boolean isUniqueness() {
		return uniqueness;
	}

	
	@Override
	public String toString() {
		return title;
	}
}