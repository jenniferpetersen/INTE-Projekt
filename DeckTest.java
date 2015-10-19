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
		Card card2 = new Card(card1[0]);
		CorpDeck corpDeck = new CorpDeck();
		corpDeck.addCard(card2);
		corpDeck.addCard(card2);
		assertEquals(2, corpDeck.getSize());
	}
	
	@Test
	public void testGetDeckOfCards() throws Exception{
		String json2 = ImportCard.readUrl("http://netrunnerdb.com/api/card/02110");
		Gson gson2 = new Gson();
		Card[] cardList = gson2.fromJson(json2, Card[].class);
		Card card2 = new Card(cardList[0]);
		CorpDeck corpDeck2 = new CorpDeck();
		corpDeck2.addCard(card2);
		corpDeck2.addCard(card2);
		assertEquals(card2, corpDeck2.getDeckOfCards().get(0));
	}

}