package netrunner;


public class FiskInvestmentSeminar extends Event{

	public FiskInvestmentSeminar() {
		super("Fisk Investment Seminar", "Priority", "Play only as your first [Click].\r\nEach player draws 3 cards.", 0, "criminal", "2",
				false);
	}
	
	public void playCard(Corporation corp, Runner runner){
		if(runner.getClicks() == 4){
			for(int i = 0; i <= 2; i++){
				corp.drawCard();	
				runner.drawCard();
			}
		}else{
			throw new java.lang.IllegalArgumentException("");
		}
	}
	
	
	
}