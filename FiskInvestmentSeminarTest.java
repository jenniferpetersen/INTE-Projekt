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
	public void testTitle()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("Fisk Investment Seminar", fisk.getTitle());
	}

	@Test
	public void testTypeCode()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("event", fisk.getTypeCode());
	}
	
	@Test
	public void testText()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("Play only as your first [Click].\r\nEach player draws 3 cards.", fisk.getText());
	}
	
	@Test
	public void testCost()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals(0, fisk.getCost());
	}
	
	@Test
	public void testFactionCode()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("criminal", fisk.getFactionCode());
	}
	
	@Test
	public void testFactioncost()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("2", fisk.getFactionCost());
	}
	
	@Test 
	public void testUniqueness()  {
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals(false, fisk.isUniqueness());
	}
	
	@Test
	public void testSubTypeCode(){
		FiskInvestmentSeminar fisk = new FiskInvestmentSeminar();
		assertEquals("Priority", fisk.getSubTypeCode());
	}
	
}