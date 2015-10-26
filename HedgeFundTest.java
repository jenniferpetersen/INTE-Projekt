package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class HedgeFundTest {

	@Test
	public void playCardTest(){
		Cerebral_Imaging corp = new Cerebral_Imaging();
		HedgeFund hf = new HedgeFund();
		hf.playCard(corp);
		assertEquals(14, corp.getCredits());
	}
	
	@Test (expected=java.lang.IllegalArgumentException.class)
	public void tooFewCreditsTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		HedgeFund hf = new HedgeFund();
		corp.loseCredits(1);
		hf.playCard(corp);
	}
}
