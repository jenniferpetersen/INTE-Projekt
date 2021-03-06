package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunnerTest {

	@Test
	public void getClickTest(){
		assertEquals(4, new Runner().getClicks());
	}
	
	@Test
	public void useClickTest(){
		Runner runner = new Runner();
		runner.useClick();
		assertEquals(3, runner.getClicks());
		assertFalse(runner.getTurnOver());
		
		runner.useClick();
		assertFalse(runner.getTurnOver());
		
		runner.useClick();
		assertFalse(runner.getTurnOver());
		
		runner.useClick();
		assertTrue(runner.getTurnOver());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void useTooManyClicks(){
		Runner runner = new Runner(); 
		runner.useClick();
		runner.useClick();
		runner.useClick();
		runner.useClick();
		runner.useClick();
	}
	
	@Test
	public void gainCreditTest(){
		Runner runner = new Runner();
		runner.gainCredits(5);
		assertEquals(10, runner.getCredits()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void gainNegativeCreditTest(){
		Runner runner = new Runner();
		runner.gainCredits(-1); 
	}
	
	@Test
	public void loseCreditTest(){
		Runner runner = new Runner();
		runner.loseCredits(3);
		assertEquals(2, runner.getCredits()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseNegativeCreditTest(){
		Runner runner = new Runner();
		runner.loseCredits(-1); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseTooManyCreditTest(){
		Runner runner = new Runner();
		runner.loseCredits(6);
	}
	
	@Test
	public void agendaPointsTest(){
		assertEquals(0, new Runner().getAgendaPoints());
		
		Runner runner = new Runner();
		runner.addAgendaPoints(3);
		assertEquals(3, runner.getAgendaPoints());
		assertFalse(runner.getWinner()); 
		
		runner.addAgendaPoints(3);
		assertEquals(6, runner.getAgendaPoints());
		assertFalse(runner.getWinner());
		
		runner.addAgendaPoints(3);
		assertEquals(9, runner.getAgendaPoints());
		assertTrue(runner.getWinner()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void agendaPointsNegativeTest(){
		new Runner().addAgendaPoints(-1);
	}
	
	@Test
	public void maxHandSizeTest(){
		assertEquals(5, new Runner().getMaxHandSize());
		
		Runner runner = new Runner();
		runner.setMaxHandSize(2);
		assertEquals(2, runner.getMaxHandSize()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void maxHandSizeNegativeTest(){
		Runner runner = new Runner();
		runner.setMaxHandSize(-1);
	}
	
	@Test
	public void addTagsTest(){
		Runner runner = new Runner();
		runner.addTag(2);
		assertEquals(2, runner.getTags());
	}
	
	@Test
	public void removeTagsTest(){
		Runner runner = new Runner();
		runner.addTag(2);
		runner.removeTag(1);
		assertEquals(1, runner.getTags());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void addTagsNegativeTest(){
		Runner runner = new Runner();
		runner.addTag(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void removeTagsZeroTest(){
		Runner runner = new Runner();
		runner.removeTag(4);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void removeTagsNegativeSumTest(){
		Runner runner = new Runner();
		runner.addTag(2);
		runner.removeTag(4);	
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void removeTagsNegativeTest(){
		Runner runner = new Runner();
		runner.removeTag(-1);
	}
	
	@Test
	public void getAmountOfCardsInGripTest(){
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.drawCard();
		assertEquals(1, runner.getAmountOfCardsInGrip());
	}
	
	@Test
	public void gainMemoryUnitTest(){
		Runner runner = new Runner();
		runner.gainMemoryUnits(4);
		assertEquals(8, runner.getMemoryUnits());
	}
	
	
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void gainNegativeMemoryUnitTest(){
		Runner runner = new Runner();
		runner.gainMemoryUnits(-1);
	}

	@Test
	public void useMemoryUnitTest(){
		Runner runner = new Runner();
		runner.useMemoryUnits(3);
		assertEquals(1, runner.getMemoryUnits());
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void useNegativeMemoryUnitTest(){
		Runner runner = new Runner();
		runner.useMemoryUnits(-1);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void useSuperPositiveMemoryUnitTest(){
		Runner runner = new Runner();
		runner.useMemoryUnits(100);
	}
	
	@Test
	public void getLastCardInGripTest(){
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.addFiskInvestmentCardToStack();
		runner.drawCard();
		assertEquals("Fisk Investment Seminar", runner.getLastCardInGrip().getTitle());
	}
	
	@Test
	public void stackIsEmptyTest(){
		Runner runner = new Runner();
		assertTrue(runner.isStackEmpty());
	}
	
	@Test
	public void drawCardTest(){
		Runner runner = new Runner();
		//silly to add card first, but the arraylist wont work otherwise
		runner.addFiskInvestmentCardToStack();
		runner.drawCard();
		Card a = runner.getLastCardInGrip();
		runner.drawCard();
		Card b = runner.getLastCardInGrip();
		assertTrue(a == b);
	}
	
	@Test
	public void takeDamageTest(){
		Runner runner = new Runner();
		for(int i = 0; i < 5; i++){ //draw 5 cards
			runner.addFiskInvestmentCardToStack();
			runner.drawCard();
		}
		runner.takeDamage(1);
		assertEquals(4, runner.getAmountOfCardsInGrip());
	}
	
	@Test
	public void takeLethalDamageTest(){
		Runner runner = new Runner();
		for(int i = 0; i < 5; i++){ //draw 5 cards
			runner.addFiskInvestmentCardToStack();
			runner.drawCard();
		}
		runner.takeDamage(6);
		assertTrue(runner.isLoser());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void takeNegativeDamageTest(){
		Runner runner = new Runner();
		for(int i = 0; i < 5; i++){ //draw 5 cards
			runner.addFiskInvestmentCardToStack();
			runner.drawCard();
		}
		runner.takeDamage(-5);
	}
	
	@Test
	public void trashCardFromGripTest() {
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.drawCard();
		runner.trashCardFromGrip(runner.getLastCardInGrip());
		assertEquals(false, runner.isHeapEmpty());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void trashCardFromEmptyGripTest(){
		Runner runner = new Runner();
		FiskInvestmentSeminar fis = new FiskInvestmentSeminar();
		runner.trashCardFromGrip(fis);
		assertEquals(true, runner.isHeapEmpty());
	}
	
	@Test
	public void buyCreditsTest(){
		Runner runner = new Runner();
		int a = runner.getCredits();
		runner.buyCreditsForClicks();
		int b = runner.getCredits();
		assertTrue(b > a);
		assertEquals(3, runner.getClicks());
	}
	
	@Test
	public void drawCardForClicksTest(){
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		int a = runner.getAmountOfCardsInGrip();
		runner.buyCardForClick();
		int b = runner.getAmountOfCardsInGrip();
		assertTrue(b > a);
	}
	
	@Test
	public void removeTagsForClicksTest(){
		Runner runner = new Runner();
		runner.addTag(2);
		runner.removeTagsForClicks();
		assertEquals(1, runner.getTags());
	}
	
	@Test
	public void makeSuccessfulAgendaRunOnHQTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToHQ(c);
		runner.attemptRun(corp, "HQ");
		assertEquals(2, runner.getAgendaPoints());
		assertEquals(1, runner.getCredits());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void makeFailedAgendaRunOnHQTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToHQ(c);
		runner.loseCredits(5);
		runner.attemptRun(corp, "HQ");
	}
	
	@Test
	public void makeSuccessfulAssetRunOnHQTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		AdonisCampaign c = new AdonisCampaign();
		corp.addCardToHQ(c);
		runner.attemptRun(corp, "HQ");
		assertTrue(runner.wasSuccessfulOnRun());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void makeFailedAssetRunOnHQTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		AdonisCampaign c = new AdonisCampaign();
		corp.addCardToHQ(c);
		runner.loseCredits(5);
		runner.attemptRun(corp, "HQ");
	}
	
	@Test
	public void makeSuccessfulAgendaRunOnRD(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToRD(c);
		runner.attemptRun(corp, "RD");
		assertEquals(2, runner.getAgendaPoints());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void makeFailedAgendaRunOnRD(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToRD(c);
		runner.loseCredits(3);
		runner.attemptRun(corp, "RD");
	}
	
	@Test
	public void makeSuccessfulAssetRunOnRD(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		AdonisCampaign c = new AdonisCampaign();
		corp.addCardToRD(c);
		runner.attemptRun(corp, "RD");
		assertTrue(runner.wasSuccessfulOnRun());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void makeFailedAssetRunOnRDTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		AdonisCampaign c = new AdonisCampaign();
		corp.addCardToRD(c);
		runner.loseCredits(5);
		runner.attemptRun(corp, "RD");
	}
	
	@Test
	public void makeSuccessfulAgendaRunOnArchives(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToArchives(c);
		runner.attemptRun(corp, "Archives");
		assertEquals(2, runner.getAgendaPoints());
	}
	
	@Test
	public void makeSuccessfulAssetRunOnArchives(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		AdonisCampaign c = new AdonisCampaign();
		corp.addCardToArchives(c);
		runner.attemptRun(corp, "Archives");
		assertTrue(runner.wasSuccessfulOnRun());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void makeFailedAssetRunOnArchivesTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		AdonisCampaign c = new AdonisCampaign();
		corp.addCardToArchives(c);
		runner.loseCredits(5);
		runner.attemptRun(corp, "Archives");
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void makeFailedAgendaRunOnArchives(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToArchives(c);
		runner.loseCredits(3);
		runner.attemptRun(corp, "archives");
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void attemptRunAtEmptyHQ(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		runner.attemptRun(corp, "HQ");
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void attemptRunAtEmptyArchives(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		runner.attemptRun(corp, "Archives");
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void attemptRunAtNoSpecificCard(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		runner.attemptRun(corp, "Archives");
	}

	@Test
	public void isInScoreAreaTest(){
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract c = new NAPD_Contract();
		corp.addCardToHQ(c);
		runner.attemptRun(corp, "HQ");
		runner.isInScoreArea(c);
	}
}
