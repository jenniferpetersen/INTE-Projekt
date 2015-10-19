package netrunner;

public class NAPD_Contract extends Agenda{
	
	public NAPD_Contract() {
		super("NAPD Contract", "security", "The advancement requirement of NAPD Contract is increased by 1 for each bad publicity the Corp has. "
				+ "	As an additional cost to steal NAPD Contract, the Runner must pay 4 credits", 4, "neutral", "0", false, 2);
	}
	
	public void stealAgenda(Corporation corp, Runner runner) {
		if (runner.getCredits() < 4) {
			System.out.println("You cannot afford to steal this agenda!");
		}
		else {
			runner.addAgendaPoints(getAgendaPoints());
			//Ta bort this från där runnern accessade (HQ, R&D, eller Archives) samt lägg till Runners SCORE AREA
		}
	}
	
	public void scoreAgenda() {
		
	}

}
