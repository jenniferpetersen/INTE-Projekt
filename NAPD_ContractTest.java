package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class NAPD_ContractTest {
	
	@Test
	public void stealTest() {
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		corp.addCardToRD(napd);
		
		napd.stealAgenda(corp, runner, "RD");
		assertEquals(2, runner.getAgendaPoints());
		assertEquals(1, runner.getCredits());
		assertTrue(runner.isInScoreArea(napd));
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void stealTooFewCreditsTest() {
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		corp.addCardToRD(napd);
		
		runner.loseCredits(2);
		
		napd.stealAgenda(corp, runner, "researchAndDevelopment");
	}
	
	@Test (expected = java.lang.NullPointerException.class)
	public void stealNullAccessedServerTest() {
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.stealAgenda(corp, runner, null);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void stealEmptyAccessedServerTest() {
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.stealAgenda(corp, runner, "");
	}
	
	@Test (expected = java.lang.NullPointerException.class)
	public void stealNullRunnerTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.stealAgenda(corp, null, "Archives");
	}
	
	@Test (expected = java.lang.NullPointerException.class)
	public void stealNullCorpTest() {
		Runner runner = new Runner();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.stealAgenda(null, runner, "Archives");
	}
	
	@Test
	public void scoreTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.advance();
		napd.advance();
		napd.advance();
		napd.advance();
		
		napd.scoreAgenda(corp);
		assertEquals(2, corp.getAgendaPoints());
		assertTrue(corp.isInScoreArea(napd));
	}
	
	@Test (expected = java.lang.NullPointerException.class) 
	public void scoreNullCorpTest() {
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.advance();
		napd.advance();
		napd.advance();
		napd.advance();
		
		napd.scoreAgenda(null);
	}
	
	@Test
	public void scoreWithBPSucceedTest() {
		Corporation corp = new Cerebral_Imaging();
		corp.addBadPublicity(1);
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.advance();
		napd.advance();
		napd.advance();
		napd.advance();
		napd.advance();
		
		napd.scoreAgenda(corp);
		assertEquals(2, corp.getAgendaPoints());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void scoreWithBadPublicityFailTest() {
		Corporation corp = new Cerebral_Imaging();
		corp.addBadPublicity(1);
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.advance();
		napd.advance();
		napd.advance();
		napd.advance();
		
		napd.scoreAgenda(corp);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void scoreTooFewAdvTokensTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.scoreAgenda(corp);
	}
	
	@Test
	public void testRemoveFromRDAfterSteal() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		Runner runner = new Runner();
		NAPD_Contract napd = new NAPD_Contract();
		corp.addCardToRD(napd);
		
		napd.stealAgenda(corp, runner, "RD");
		assertTrue(corp.isRDEmpty());
	}
	
	@Test
	public void testRemoveFromArchivesAfterSteal() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		Runner runner = new Runner();
		NAPD_Contract napd = new NAPD_Contract();
		corp.addCardToArchives(napd);
		
		napd.stealAgenda(corp, runner, "Archives");
		assertEquals(0, corp.getSizeArchives());
	}
	
	@Test
	public void testRemoveFromHQAfterSteal() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		Runner runner = new Runner();
		NAPD_Contract napd = new NAPD_Contract();
		corp.addCardToHQ(napd);
		
		napd.stealAgenda(corp, runner, "HQ");
		assertEquals(0, corp.getSizeHQ());
	}

}
