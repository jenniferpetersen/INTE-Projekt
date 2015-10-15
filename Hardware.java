package netrunner;

public class Hardware extends RunnerCard {
	
	public Hardware(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost,
			boolean uniqueness){
		
		super(title, "hardware", subTypeCode, text, cost, faction, factionCode, factionletter, factionCost, uniqueness);
	}

}
