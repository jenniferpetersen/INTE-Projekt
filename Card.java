public class Card {
	private String title;
	private String type;
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
 

	
	public Card(String title, String type, String typecode, String subTypeCode,
			String text, int cost, String faction, String factionCode, String factionletter, String factionCost, 
			String flavor, String number, boolean uniqueness) {
		
		this.title = title;
		this.type = type;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeCode() {
		return type_code;
	}

	public void setTypeCode(String typecode) {
		this.type_code = typecode;
	}

	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getFactionCode() {
		return faction_code;
	}

	public void setFactionCode(String factionCode) {
		this.faction_code = factionCode;
	}

	public String getFactionLetter() {
		return faction_letter;
	}

	public void setFactionLetter(String factionletter) {
		this.faction_letter = factionletter;
	}

	public String getFactionCost() {
		return factioncost;
	}

	public void setFactioncost(String factioncost) {
		this.factioncost = factioncost;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isUniqueness() {
		return uniqueness;
	}

	public void setUniqueness(boolean uniqueness) {
		this.uniqueness = uniqueness;
	}
	
	@Override
	public String toString() {
		return number;
	}
}
