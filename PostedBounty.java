package netrunner;

public class PostedBounty extends Agenda{

	public PostedBounty(String title, String typecode, String subTypeCode, String text, int cost, String faction,
			String factionCode, String factionletter, String factionCost, boolean uniqueness) {
		super("Posted Bounty", typecode, "security", "When you score Posted Bounty, you may forfeit it to give the Runner 1 tag and take 1 bad publicity.", 3, "Weyland Consortium", "weyland-consortium", "w", factionCost, false);
		}

	public void forfeitCard(Runner runner, Corporation corp){
		runner.addTag(1);
	//	corp.addBadPublicity(1);
	}
	
	public void scoreAgenda(Corporation corp){
		corp.addAgendaPoints(1);
	}
}
