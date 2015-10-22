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
	
	@Test
	public void testRezCard() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		
		ac.installCard(corp);
		ac.rezCard();
		assertEquals(12, ac.getCredits());
		assertTrue(ac.isRezzed());
	}
	
	@Test
	public void testUseCredits() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		
		ac.installCard(corp);
		ac.rezCard();
		ac.startOfTurn(corp);
		assertEquals(9, ac.getCredits());
		assertEquals(8, corp.getCredits());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUseCreditsNotRezzed() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		
		ac.installCard(corp);
		ac.startOfTurn(corp);
	}
	
	@Test
	public void testUseAllCredits() {
		Corporation corp = new Cerebral_Imaging();
		AdonisCampaign ac = new AdonisCampaign();
		corp.addCardToHQ(ac);
		
		ac.installCard(corp);
		ac.rezCard();
		ac.startOfTurn(corp);
		ac.startOfTurn(corp);
		ac.startOfTurn(corp);
		ac.startOfTurn(corp);
		
		assertEquals(0, ac.getCredits());
		assertTrue(corp.isCardInArchives(ac));
		assertFalse(ac.getInstalledServer().contains(ac));
	}
}
