

public class Card {
	private String code;
	private String title;
	private String type;
	private String typeCode;
	private String subTypeCode;
	private String text;
	private int cost;
	private String faction;
	private String factionCode;
	private String factionLetter;
	private int factionCost;
	private String flavor;
	private String illustrator;
	private String number;
	private String quantity;
	private String setName;
	private String setCode;
	private boolean uniqueness;
	private boolean limited;
	private String cyclenumber;

	
	public Card(String code, String title, String type, String typeCode, String subTypeCode,
			String text, int cost, String faction, String factionCode, String factionLetter, int factionCost, 
			String flavor, String illustrator, String number, String quantity, String setName, 
			String setCode, boolean uniqueness, boolean limited, String cyclenumber) {
		
		this.code = code;
		this.title = title;
		this.type = type;
		this.typeCode = typeCode;
		this.subTypeCode = subTypeCode;
		this.text = text;
		this.cost = cost;
		this.faction = faction;
		this.factionCode = factionCode;
		this.factionLetter = factionLetter;
		this.factionCost = factionCost;
		this.flavor = flavor;
		this.illustrator = illustrator;
		this.number = number;
		this.quantity = quantity;
		this.setName = setName;
		this.setCode = setCode;
		this.uniqueness = uniqueness;
		this.limited = limited;
		this.cyclenumber = cyclenumber;

		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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
		return factionCode;
	}

	public void setFactionCode(String factionCode) {
		this.factionCode = factionCode;
	}

	public String getFactionLetter() {
		return factionLetter;
	}

	public void setFactionLetter(String factionLetter) {
		this.factionLetter = factionLetter;
	}

	public int getFactionCost() {
		return factionCost;
	}

	public void setFactionCost(int factionCost) {
		this.factionCost = factionCost;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getIllustrator() {
		return illustrator;
	}

	public void setIllustrator(String illustrator) {
		this.illustrator = illustrator;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public boolean isUniqueness() {
		return uniqueness;
	}

	public void setUniqueness(boolean uniqueness) {
		this.uniqueness = uniqueness;
	}

	public boolean isLimited() {
		return limited;
	}

	public void setLimited(boolean limited) {
		this.limited = limited;
	}

	public String getCyclenumber() {
		return cyclenumber;
	}

	public void setCyclenumber(String cyclenumber) {
		this.cyclenumber = cyclenumber;
	}
	
	@Override
	public String toString() {
		return code;
	}
}