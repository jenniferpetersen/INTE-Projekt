package netrunner;

public class Hardware extends RunnerCard {
	
	public Hardware(String title, String subTypeCode, String text, int cost,
			String factionCode, String factionCost,
			boolean uniqueness){
		
		super(title, "hardware", subTypeCode, text, cost, factionCode,  factionCost, uniqueness);
	}

}
