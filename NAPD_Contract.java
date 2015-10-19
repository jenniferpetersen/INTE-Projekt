package netrunner;

public class NAPD_Contract extends Agenda{
	
	public NAPD_Contract() {
		super("NAPD Contract", "security", "The advancement requirement of NAPD Contract is increased by 1 for each bad publicity the Corp has. "
				+ "	As an additional cost to steal NAPD Contract, the Runner must pay 4 credits", 4, "neutral", "0", false, 2);
	}
	
	public void stealAgenda(Corporation corp, Runner runner, String accessedServer) {
		if (runner.getCredits() < 4) {
			throw new IllegalArgumentException("You don't have enough credits to steal this!");
		}
		else if (accessedServer == null || runner == null || corp == null) {
			throw new NullPointerException();
		}
		else {
			runner.addToScoreArea(this);
			runner.loseCredits(4);
			
			switch(accessedServer) {
			case "researchAndDevelopment": corp.removeCardFromRD(this);
										break;
			case "Archives":	corp.removeCardFromArchives(this);
								break;
			case "HQ":			corp.removeCardFromHQ(this);
								break;
			case "":			throw new IllegalArgumentException("You need to specify where the agenda was accessed from");
					
			}
			
		}
	}
	
	public void scoreAgenda(Corporation corp) {
		if (this.getAdvancementTokens() >= this.getCost()) {
			corp.addToScoreArea(this);
		}
		else {
			throw new java.lang.IllegalArgumentException("Agenda is not advanced enough to score!");
		}

	}

}
