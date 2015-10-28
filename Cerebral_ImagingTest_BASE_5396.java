package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cerebral_ImagingTest {
	
	@Test
	public void advanceAgendaTest() {
		Cerebral_Imaging CI = new Cerebral_Imaging();
		Agenda napd = new NAPD_Contract();
		
		CI.advanceAgenda(napd);
		assertEquals(1, napd.getAdvancementTokens());
		assertEquals(4, CI.getCredits());
	}
	
	@Test (expected = NullPointerException.class)
	public void advanceNullAgendaTest() {
		Cerebral_Imaging CI = new Cerebral_Imaging();
		CI.advanceAgenda(null);
	}

	@Test
	public void gainCreditsHandSizeTest() {
		Cerebral_Imaging CI = new Cerebral_Imaging();
		CI.gainCredits(1);
		assertEquals(6, CI.getMaxHandSize());
	}
	
	@Test
	public void loseCreditsHandSizeTest() {
		Cerebral_Imaging CI = new Cerebral_Imaging();
		CI.loseCredits(1);
		assertEquals(4, CI.getMaxHandSize());
	}

	@Test
	public void getClickTest() {
		assertEquals(3,new Cerebral_Imaging().getClicks());
	}
	
	@Test
	public void useClickTest() { 
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.useClick();
		assertEquals(2,corp.getClicks());
		assertFalse(corp.getTurnOver());
		
		corp.useClick();
		assertFalse(corp.getTurnOver());
		
		corp.useClick();
		assertTrue(corp.getTurnOver());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void useTooManyClicks() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.useClick();
		corp.useClick();
		corp.useClick();
		corp.useClick();
	}
	
	@Test 
	public void addBadPublicityTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addBadPublicity(1);
		assertEquals(1, corp.getBadPublicity());
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void addNegativeBadPublicityTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addBadPublicity(-1);
	}
	
	@Test
	public void removeBadPublicityTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addBadPublicity(1);
		corp.removeBadPublicity(1);
		assertEquals(0, corp.getBadPublicity());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void removeNegativeBadPublicityTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addBadPublicity(1);
		corp.removeBadPublicity(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void removeBadPublicityFromZeroTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.removeBadPublicity(1);
	}
		
	@Test
	public void getCreditsTest() {
		assertEquals(5,new Cerebral_Imaging().getCredits());
	}
	
	@Test
	public void gainCreditTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.gainCredits(4);
		assertEquals(9, corp.getCredits());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void gainNegativeCreditTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.gainCredits(-1);
	}
	
	@Test
	public void loseCreditTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.loseCredits(4);
		assertEquals(1, corp.getCredits());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseNegativeCreditTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.loseCredits(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseTooManyCreditTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.loseCredits(6);
		assertEquals(0, corp.getCredits());
	}
	
	@Test
	public void agendaPointsTest() {
		assertEquals(0, new Cerebral_Imaging().getAgendaPoints());
		
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addAgendaPoints(2);
		assertEquals(2, corp.getAgendaPoints());
		assertFalse(corp.getWinner());
		
		corp.addAgendaPoints(2);
		assertEquals(4, corp.getAgendaPoints());
		assertFalse(corp.getWinner());
		
		corp.addAgendaPoints(3);
		assertEquals(7, corp.getAgendaPoints());
		assertTrue(corp.getWinner());
	}	
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void agendaPointsTestNegative() {
		new Cerebral_Imaging().addAgendaPoints(-1);
	}
	
	
	@Test
	public void maxHandSizeTest() {
		assertEquals(5, new Cerebral_Imaging().getMaxHandSize());
		
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.setMaxHandSize(3);
		assertEquals(3, corp.getMaxHandSize());
		
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void maxHandSizeTestNegative() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.setMaxHandSize(-1);
	}
	
	@Test
	public void drawCardTest() {	//drar kort från R&D där det ligger 2 kort
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addCardToRD(new Card("Noise"));
		corp.addCardToRD(new Card("Snare!"));
		Card drawnCard = corp.getTopCardRD();
		corp.drawCard();
		assertFalse(corp.compareTopCardRD(drawnCard));	//ett nytt kort skall nu ligga överst i R&D, och ej vara samma som det som drogs
		assertTrue(corp.compareLastCardHQ(drawnCard));
	}
	
	@Test
	public void drawCardFromEmptyRD() {		//kontrollerar att Corp förlorar om man drar kort från tom R&D
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.drawCard();
		assertTrue(corp.isLoser());
	}
	
	@Test
	public void drawCardFromRDWithOneCard() {	//kontrollerar om man kan dra kort från R&D om där ligger 1 kort
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addCardToRD(new Card("Noise"));
		Card RDCard = corp.getTopCardRD();
		corp.drawCard();
		assertTrue(corp.isRDEmpty());
		assertTrue(RDCard.equals(corp.getLastCardHQ()));
	}
	
	@Test
	public void trashCardFromHQTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addCardToRD(new Card("Noise"));
		corp.drawCard();
		corp.trashCardFromHQ(corp.getLastCardHQ());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void trashCardFromEmptyHQTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.trashCardFromHQ(new Card("Noise"));
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void trashCardNotInHQ() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.addCardToRD(new Card("Noise"));
		corp.drawCard();
		corp.trashCardFromHQ(new Card("Snare!"));
	}
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void trashNullFromHQ() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.trashCardFromHQ(null);
	}
}
