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
	public void testDrawThreeCardsFail() {
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.addFiskInvestmentCardToStack();
		for(int index = 0; index <= 2; index++){
			runner.drawCard();
			
		}	
	}		
	
	@Test
	public void testDrawThreeCardsSuccess() {
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.addFiskInvestmentCardToStack();
		runner.addFiskInvestmentCardToStack();
		for(int index = 0; index <= 2; index++){
			runner.drawCard();
		}	
	}
}
