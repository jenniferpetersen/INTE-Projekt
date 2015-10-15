package netrunner;


public class FiskInvestmentSeminar extends Event{

	public FiskInvestmentSeminar(String title, String typecode, String subTypeCode, String text, int cost,
			String faction, String factionCode, String factionletter, String factionCost,
			boolean uniqueness) {
		super("Fisk Investment Seminar", typecode, "Priority", "Play only as your first [Click].\r\nEach player draws 3 cards.", 0, "Criminal", "criminal", "c", "2",
				false);
	}
	
	
	
	
	
}