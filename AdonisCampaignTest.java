package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdonisCampaignTest {

	@Test
	public void testInstallCard() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		
		ac.installCard(corp);
		assertFalse(corp.isCardInHQ(ac));
		//Hur testa att kortet har installerats i en remote? Skapa en remote, skicka med och installera kortet där?
	}

}
