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
		assertEquals(3, corp.getSizeHQ());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testPlayCardNotFirstClick(){
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		Runner runner = new Runner();
		runner.useClick();
		fisk.playCard(corp,  runner);
	}
	
	@Test
	public void testTitle() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("Fisk Investment Seminar", fisk.getTitle());
	}

	@Test
	public void testTypeCode() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("event", fisk.getTypeCode());
	}
	@Test
	public void testText() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("Play only as your first [Click].\r\nEach player draws 3 cards.", fisk.getText());
	}@Test
	public void testCost() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals(0, fisk.getCost());
	}@Test
	public void testFactionCode() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("criminal", fisk.getFactionCode());
	}@Test
	public void testFactioncost() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("2", fisk.getFactionCost());
	}@Test 
	public void testUniqueness() throws Exception{
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals(false, fisk.isUniqueness());
	}
}