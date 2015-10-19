package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorpCardTest {

	@Test
	public void testAddAdvancementToken() {
		CorpCard corp = new CorpCard("Hedgefund");
		corp.addAdvancementTokens(1);
		assertEquals(1, corp.getAdvancementTokens());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testAddAdvancementTokenNegative(){
		CorpCard corp = new CorpCard("Hedgefund");
		corp.addAdvancementTokens(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testAddNegativeAdvancementToken(){
		CorpCard corp = new CorpCard("Hedgefund");
		corp.addAdvancementTokens(-1);
	}
	
	@Test
	public void testRemoveAdvancementTokens(){
		CorpCard corp = new CorpCard("Hedgefund");
		corp.addAdvancementTokens(5);
		corp.removeAdvancementTokens(3);
		assertEquals(2, corp.getAdvancementTokens());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRemoveNegativeAdvancementTokens(){
		CorpCard corp = new CorpCard("Hedgefund");
		corp.removeAdvancementTokens(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRemoveAdvancementTokensNegative(){
		CorpCard corp = new CorpCard("Hedgefund");
		corp.addAdvancementTokens(0);
		corp.removeAdvancementTokens(1);
	}
	
	@Test
	public void testBuyAdvancementTokens(){
		Cerebral_Imaging corp = new Cerebral_Imaging();
		CorpCard corpcard = new CorpCard("Hedgefund");
		corpcard.buyAdvancementTokens(corp);
		assertEquals(4, corp.getCredits());
	}
	
}
