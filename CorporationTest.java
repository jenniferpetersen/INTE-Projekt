package saker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporationTest {

	@Test
	public void getClickTest() {
		assertEquals(3,new Corporation().getClicks());
	}
	
	@Test
	public void setClickTest() {
		Corporation corp = new Corporation();
		corp.changeClicks();
		assertEquals(2,corp.getClicks());
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
	
	@Test
	public void loseCreditTest() {
		Corporation corp = new Corporation();
		corp.loseCredits(4);
		assertEquals(1, corp.getCredits());
	}
	
	@Test
	public void agendaPointsTest() {
		assertEquals(0, new Corporation().getAgendaPoints());
		
		Corporation corp = new Corporation();
		corp.addAgendaPoints(2);
		assertEquals(2, corp.getAgendaPoints());
		
		corp.addAgendaPoints(2);
		assertEquals(4, corp.getAgendaPoints());
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
}
