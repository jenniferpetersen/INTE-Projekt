package netrunner;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AdonisCampaignTest {

	@Test
	public void testInstallCardNewRemote() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		
		ac.installCard(corp);
		assertFalse(corp.isCardInHQ(ac));
		assertEquals(1, corp.getNoOfRemoteServers());
	}
	
	@Test
	public void testInstallCardExistingRemote() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		ArrayList<Card> remote = corp.createRemoteServer();
		
		ac.installCard(corp, remote);
		assertFalse(corp.isCardInHQ(ac));
		assertEquals(1, corp.getNoOfRemoteServers());
	}

	@Test
	public void testTrashCard() {
		Runner runner = new Runner();
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);

		ac.trashCard(runner, corp);
		assertEquals(2, runner.getCredits());
		assertFalse(corp.isCardInHQ(ac));
	}
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testTrashCardLowCredits() {
		Runner runner = new Runner();
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		runner.loseCredits(3);

		ac.trashCard(runner, corp);
	}
}
