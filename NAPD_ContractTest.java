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
		
		napd.stealAgenda(corp, runner, "researchAndDevelopment");
		assertEquals(2, runner.getAgendaPoints());
		assertEquals(1, runner.getCredits());
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
		
		napd.stealAgenda(corp, runner, "researchAndDevelopment");
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
