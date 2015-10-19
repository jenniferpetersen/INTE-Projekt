package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cerebral_ImaginingTest {

	@Test
	public void gainCreditsHandSizeTest() {
		Cerebral_Imagining CI = new Cerebral_Imagining();
		CI.gainCredits(1);
		assertEquals(6, CI.getMaxHandSize());
	}
	
	@Test
	public void loseCreditsHandSizeTest() {
		Cerebral_Imagining CI = new Cerebral_Imagining();
		CI.loseCredits(1);
		assertEquals(4, CI.getMaxHandSize());
	}

	@Test (expected = java.lang.IllegalArgumentException.class)
	public void gainNegCreditsHandSizeTest() {
		Cerebral_Imagining CI = new Cerebral_Imagining();
		CI.gainCredits(-1);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void loseNegCreditsHandSizeTest() {
		Cerebral_Imagining CI = new Cerebral_Imagining();
		CI.loseCredits(-1);
	}
}
