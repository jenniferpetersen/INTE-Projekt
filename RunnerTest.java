package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunnerTest {

	@Test
	public void getClickTestR(){
		assertEquals(4, new Runner().getClicks());
	}
	
	@Test
	public void useClickTestR(){
		Runner runner = new Runner();
		runner.useClick();
		assertEquals(3, runner.getClicks());
		assertFalse(runner.getTurnOver());
		
		runner.useClick();
		assertFalse(runner.getTurnOver());
		
		runner.useClick();
		assertFalse(runner.getTurnOver());
		
		runner.useClick();
		assertTrue(runner.getTurnOver());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void useTooManyClicksR(){
		Runner runner = new Runner(); 
		runner.useClick();
		runner.useClick();
		runner.useClick();
		runner.useClick();
		runner.useClick();
	}
	
	@Test
	public void gainCreditTestR(){
		Runner runner = new Runner();
		runner.gainCredits(5);
		assertEquals(10, runner.getCredits()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void gainNegativeCreditTestR(){
		Runner runner = new Runner();
		runner.gainCredits(-1); 
	}
	
	@Test
	public void loseCreditTestR(){
		Runner runner = new Runner();
		runner.loseCredits(3);
		assertEquals(2, runner.getCredits()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseNegativeCreditTestR(){
		Runner runner = new Runner();
		runner.loseCredits(-1); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void loseTooManyCreditTestR(){
		Runner runner = new Runner();
		runner.loseCredits(6);
		assertEquals(0, runner.getCredits());
	}
	
	@Test
	public void agendaPointsTestR(){
		assertEquals(0, new Runner().getAgendaPoints());
		
		Runner runner = new Runner();
		runner.addAgendaPoints(3);
		assertEquals(3, runner.getAgendaPoints());
		assertFalse(runner.getWinner()); 
		
		runner.addAgendaPoints(3);
		assertEquals(6, runner.getAgendaPoints());
		assertFalse(runner.getWinner());
		
		runner.addAgendaPoints(3);
		assertEquals(9, runner.getAgendaPoints());
		assertTrue(runner.getWinner()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void agendaPointsTestNegativeR(){
		new Runner().addAgendaPoints(-1);
	}
	
	@Test
	public void maxHandSizeTestR(){
		assertEquals(5, new Runner().getMaxHandSize());
		
		Runner runner = new Runner();
		runner.setMaxHandSize(2);
		assertEquals(2, runner.getMaxHandSize()); 
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void maxHandSizeTestNegative(){
		Runner runner = new Runner();
		runner.setMaxHandSize(-1);
	}
	
	@Test
	public void addTagsTest(){
		Runner runner = new Runner();
		runner.addTag(2);
		assertEquals(2, runner.getTags());
	}
	
	@Test
	public void removeTagsTest(){
		Runner runner = new Runner();
		runner.addTag(2);
		runner.removeTag(1);
		assertEquals(1, runner.getTags());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void addTagsTestNegative(){
		Runner runner = new Runner();
		runner.addTag(-1);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void removeTagsTestNegative(){
		Runner runner = new Runner();
		runner.removeTag(4);
	}
	
	@Test
	public void getAmountOfCardsInGripTest(){
		Runner runner = new Runner();
		runner.addFiskInvestmentCardToStack();
		runner.drawCard();
		assertEquals(1, runner.getAmountOfCardsInGrip());
	}
	
}