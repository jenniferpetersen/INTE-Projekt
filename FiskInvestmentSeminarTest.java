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
		//ugly code. fix somehow?
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		Cerebral_Imaging corp = new Cerebral_Imaging();
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
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		Runner runner = new Runner();
		runner.useClick();
		fisk.playCard(corp,  runner);
	}
	
	
}
