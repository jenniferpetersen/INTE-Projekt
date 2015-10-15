package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporationTest {

	@Test
	public void getClickTest() {
		assertEquals(3,new Corporation().getClicks());
	}
	
	@Test
	public void useClickTest() {
		Corporation corp = new Corporation();
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
		Corporation corp = new Corporation();
		corp.useClick();
		corp.useClick();
		corp.useClick();
		corp.useClick();
	}
		
	@Test
	public void getCreditsTest() {
		assertEquals(5,new Corporation().getCredits());
	}
	
	@Test
	public void gainCreditTest() {
		Corporation corp = new Corporation();
		corp.gainCredits(4);
		assertEquals(9, corp.getCredits());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void gainNegativeCreditTest() {
		Corporation corp = new Corporation();
		corp.gainCredits(-1);
	}
	
	@Test
	public void loseCreditTest() {
		Corporation corp = new Corporation();
		corp.loseCredits(4);
		assertEquals(1, corp.getCredits());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseNegativeCreditTest() {
		Corporation corp = new Corporation();
		corp.loseCredits(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseTooManyCreditTest() {
		Corporation corp = new Corporation();
		corp.loseCredits(6);
		assertEquals(0, corp.getCredits());
	}
	
	@Test
	public void agendaPointsTest() {
		assertEquals(0, new Corporation().getAgendaPoints());
		
		Corporation corp = new Corporation();
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
		new Corporation().addAgendaPoints(-1);
	}
	
	
	@Test
	public void maxHandSizeTest() {
		assertEquals(5, new Corporation().getMaxHandSize());
		
		Corporation corp = new Corporation();
		corp.setMaxHandSize(3);
		assertEquals(3, corp.getMaxHandSize());
		
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void maxHandSizeTestNegative() {
		Corporation corp = new Corporation();
		corp.setMaxHandSize(-1);
	}
	
	@Test
	public void drawCardTest() {	//drar kort från R&D där det ligger 2 kort
		Corporation corp = new Corporation();
		corp.addCardToRD(new Card("Noise"));
		corp.addCardToRD(new Card("Snare!"));
		Card drawnCard = corp.getTopCardRD();
		corp.drawCard();
		assertFalse(corp.compareTopCardRD(drawnCard));	//ett nytt kort skall nu ligga överst i R&D, och ej vara samma som det som drogs
		assertTrue(corp.compareLastCardHQ(drawnCard));
	}
	
	@Test
	public void drawCardFromEmptyRD() {		//kontrollerar att Corp förlorar om man drar kort från tom R&D
		Corporation corp = new Corporation();
		corp.drawCard();
		assertTrue(corp.isLoser());
	}
	
	@Test
	public void drawCardFromRDWithOneCard() {	//kontrollerar om man kan dra kort från R&D om där ligger 1 kort
		Corporation corp = new Corporation();
		corp.addCardToRD(new Card("Noise"));
		Card RDCard = corp.getTopCardRD();
		corp.drawCard();
		assertTrue(corp.isRDEmpty());
		assertTrue(RDCard.equals(corp.getLastCardHQ()));
	}
	
	@Test
	public void trashCardFromHQTest() {
		Corporation corp = new Corporation();
		corp.addCardToRD(new Card("Noise"));
		corp.drawCard();
		corp.trashCardFromHQ(corp.getLastCardHQ());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void trashCardFromEmptyHQTest() {
		Corporation corp = new Corporation();
		corp.trashCardFromHQ(new Card("Noise"));
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void trashCardNotInHQ() {
		Corporation corp = new Corporation();
		corp.addCardToRD(new Card("Noise"));
		corp.drawCard();
		corp.trashCardFromHQ(new Card("Snare!"));
	}
}
