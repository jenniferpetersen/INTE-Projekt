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
	
	@Test
	public void testRemoveAdvancementTokens(){
		
	}
	
	@Test
	public void testRemoveAdvancementTokensNegative(){
		
	}
}
