package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cerebral_ImaginingTest {

	@Test
	public void addCreditsHandSizeTest() {
		Cerebral_Imagining CI = new Cerebral_Imagining();
		CI.gainCredits(1);
		assertEquals(6, CI.getMaxHandSize());
	}

}
