package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class FiskInvestmentSeminarTest {

	@Test
	public void testFirstClick() {
		Runner runner = new Runner();
		assertEquals(4, runner.getClicks());
	}
	
	@Test
	public void testPlayCard(){
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar("Fisk Investment Seminar", "event", "Priority", "Play only as your first [Click].\r\nEach player draws 3 cards.", 0, "Criminal", "criminal", "c", "2",
					false);
		Corporation corp = new Corporation();
		Runner runner = new Runner();
		for(int i = 0; i <= 2; i++){
			corp.addCardToRD(fisk);
			runner.addFiskInvestmentCardToStack();
		}
		fisk.playCard(corp, runner);
		assertEquals(3, runner.getAmountOfCardsInGrip());
		//assertEquals(3, corp.getAmountOfCardsInHQ());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testPlayCardNotFirstClick(){
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar("Fisk Investment Seminar", "event", "Priority", "Play only as your first [Click].\r\nEach player draws 3 cards.", 0, "Criminal", "criminal", "c", "2",
				false);
		Corporation corp = new Corporation();
		Runner runner = new Runner();
		runner.useClick();
		fisk.playCard(corp,  runner);
	}
	
	
}
