package saker;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class DeckTest {


/*	@Test
	**UTDATERAT TEST**
	**Testet användes innan klassen Deck blev abstrakt**

	public void testCardAdding() throws Exception {
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01001");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		Deck deck = new Deck();
		deck.addCard(card);
		assertEquals(deck.getSize(), 1);
	}*/
	
	@Test
	public void testAddFactionSpecificCard() throws Exception {
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/02110");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		CorpDeck corpDeck = new CorpDeck();
		corpDeck.addCard(card, 1);
		assertEquals(1, corpDeck.getDeckOfCards());
		
	}

}
