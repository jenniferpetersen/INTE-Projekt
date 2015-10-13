package saker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporationTest {

	@Test
	public void getClickTest() {
		assertEquals(3,new Corporation().getClicks());
	}
	
	public void setClickTest() {
		Corporation corp = new Corporation();
		corp.changeClicks();
		assertEquals(2,corp.getClicks());
	}
	
	public void getCreditsTest() {
		assertEquals(5,new Corporation().getCredits());
	}
	
	public void gainCreditTest() {
		Corporation corp = new Corporation();
		corp.gainCredits(4);
		assertEquals(9, corp.getCredits());
	}
	
	public void loseCreditTest() {
		Corporation corp = new Corporation();
		corp.loseCredits(4);
		assertEquals(1, corp.getCredits());
	}
}
