package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class HedgeFundTest {

	@Test
	public void playCardTest(){
		Cerebral_Imaging corp = new Cerebral_Imaging();
		corp.gainCredits(9);
		assertEquals(14, corp.getCredits());
	}

}
