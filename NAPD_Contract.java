package netrunner;

import java.util.ArrayList;

public class NAPD_Contract extends Agenda{
	
	//lägg in metod för att installera i ny eller existerande remote server!
	
	public NAPD_Contract() {
		super("NAPD Contract", "security", "The advancement requirement of NAPD Contract is increased by 1 for each bad publicity the Corp has. "
				+ "	As an additional cost to steal NAPD Contract, the Runner must pay 4 credits", 4, "neutral", "0", false, 2);
	}
	
	protected void stealAgenda(Corporation corp, Runner runner, String accessedServer) {
		if (runner.getCredits() < 4) {
			throw new IllegalArgumentException("You don't have enough credits to steal this!");
		}
		else {
			runner.addToScoreArea(this);
			runner.loseCredits(4);
			
			if (accessedServer.equals("RD")) {
					corp.removeCardFromRD(this);
			}
			else if (accessedServer.equals("Archives")) {
					corp.removeCardFromArchives(this);
			}

			else if (accessedServer.equals("HQ")) {
					corp.removeCardFromHQ(this);
			}
			else {
					throw new IllegalArgumentException("You need to specify where the agenda was accessed from");
			}
					
			}
	}
	
	protected void scoreAgenda(Corporation corp) {
		int scoreCost = this.getCost() + corp.getBadPublicity();

		if (this.getAdvancementTokens() >= scoreCost) {
			corp.addToScoreArea(this);
		}
		else {
			throw new java.lang.IllegalArgumentException("Agenda is not advanced enough to score!");
		}

	}

}
