import static org.junit.Assert.*;

import org.junit.Test;


public class HedgeFundTest {

	@Test
	public void getCostTest(){
		assertEquals(5, new HedgeFund().getCost()); 
	}
	
	@Test
	public void getTypeTest(){
		assertEquals("Operation", new HedgeFund().getType()); 
	}
	
	@Test
	public void getTextTest(){
<<<<<<< HEAD
		assertEquals("Gain 9 credits", new HedgeFund().getTest()); 
	}
	
=======
		assertEquals("Gain 9 credits", new HedgeFund().getText());
	}
	
	
>>>>>>> testbranch
	@Test
	public void gainCreditsTest(){
		HedgeFund hf = new HedgeFund();
		hf.gainCredits(3);
		assertEquals(12, hf.gainCredits(3));
		
	}
}
