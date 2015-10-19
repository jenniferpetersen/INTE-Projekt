package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class NAPD_ContractTest {

	@Test
	public void stealTest() {
		Runner runner = new Runner();
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.stealAgenda(corp, runner, "Archives");
		assertEquals(2, runner.getAgendaPoints());
	}
	
	@Test
	public void scoreTest() {
		Cerebral_Imaging corp = new Cerebral_Imaging();
		NAPD_Contract napd = new NAPD_Contract();
		
		napd.scoreAgenda(corp, "Archives");
		assertEquals(2, corp.getAgendaPoints());
	}

}
