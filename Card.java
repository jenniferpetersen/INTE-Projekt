package saker;

public class Card {
	private String title;
	private String subTypeCode;
	private String text;
	private int cost;
	private String faction;
	private String number;
	private boolean uniqueness;
	private String faction_code; 
	private String factioncost; 
	private String faction_letter;
	private String type_code; 
 
	public Card (String title) {
		this.title = title;
	}
	
	public Card(String title, String typecode, String subTypeCode,
			String text, int cost, String faction, String factionCode, String factionletter, String factionCost, String number, 
			boolean uniqueness) {
		
		this.title = title;
		this.type_code = typecode;
		this.subTypeCode = subTypeCode;
		this.text = text;
		this.cost = cost;
		this.faction = faction;
		this.faction_code = factionCode;
		this.faction_letter = factionletter;
		this.factioncost = factionCost;
		this.number = number;
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


	public String getFaction() {
		return faction;
	}


	public String getFactionCode() {
		return faction_code;
	}


	public String getFactionLetter() {
		return faction_letter;
	}


	public String getFactionCost() {
		return factioncost;
	}


	public String getNumber() {
		return number;
	}

	public boolean isUniqueness() {
		return uniqueness;
	}

	
	@Override
	public String toString() {
		return number;
	}
}