package netrunner;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class DeckTest {

	
	@Test
	public void testGetSize() throws Exception {
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/02110");
		Gson gson = new Gson();
		Card[] card1 = gson.fromJson(json, Card[].class);
		CorpDeck corpDeck = new CorpDeck();
		corpDeck.addCard(card1, 0);
		corpDeck.addCard(card1, 0);
		assertEquals(2, corpDeck.getSize());
	}
	
	@Test
	public void testGetDeckOfCardsCorp() throws Exception{
		String json2 = ImportCard.readUrl("http://netrunnerdb.com/api/card/02110");
		Gson gson2 = new Gson();
		Card[] cardList = gson2.fromJson(json2, Card[].class);
		CorpDeck corpDeck2 = new CorpDeck();
		corpDeck2.addCard(cardList, 0);
		corpDeck2.addCard(cardList, 0);
		assertEquals(cardList[0], corpDeck2.getDeckOfCards().get(0));
	}
	
	
	@Test
	public void testGetDeckOfCardsRunner() throws Exception{
		String json2 = ImportCard.readUrl("http://netrunnerdb.com/api/card/01044"); 
		Gson gson2 = new Gson();
		Card[] cardList = gson2.fromJson(json2, Card[].class);
		RunnerDeck runnerDeck = new RunnerDeck();
		runnerDeck.addCard(cardList, 0);
		assertEquals(cardList[0], runnerDeck.getDeckOfCards().get(0));
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testGetDeckOfCardsRunnerFail() throws Exception{ //Adding corp card to runner deck
		String json2 = ImportCard.readUrl("http://netrunnerdb.com/api/card/02110"); 
		Gson gson2 = new Gson();
		Card[] cardList = gson2.fromJson(json2, Card[].class);
		RunnerDeck runnerDeck = new RunnerDeck();
		runnerDeck.addCard(cardList, 0);
	}

}