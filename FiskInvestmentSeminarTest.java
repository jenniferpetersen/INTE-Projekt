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
		try{
			for(int index = 0; index <= 2; index++){
				if(runner.getTopCardFromStack() == null){
					//Once the code gets here, the trycatch detects an error
					//More elegant solution?
				}else{	runner.drawCard();
				}
			}
			
		}catch (IndexOutOfBoundsException e){
			assertTrue(runner.isStackEmpty());
		}		
	}
	
	@Test
	public void testDrawThreeCardsSuccess() {
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.addFiskInvestmentCardToStack();
		runner.addFiskInvestmentCardToStack();
		try{
			for(int index = 0; index <= 2; index++){
				if(runner.getTopCardFromStack() == null){
					//Same as above, except code never gets here, always succeeds.
				}else{	runner.drawCard();
				}
			}
			
		}catch (IndexOutOfBoundsException e){
			assertTrue(runner.isStackEmpty());
		}		
	}
}
