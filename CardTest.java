import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class CardTest {

	
	@Test
	public void testTitle() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("Archived Memories", card[0].getTitle());
	}
	@Test
	public void testType() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("Operation", card[0].getType());
	}
	@Test
	public void testTypeCode() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("operation", card[0].getTypeCode());
	}
	@Test
	public void testText() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("Add 1 card from Archives to HQ.", card[0].getText());
	}@Test
	public void testCost() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals(0, card[0].getCost());
	}@Test
	public void testFaction() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("Haas-Bioroid", card[0].getFaction());
	}@Test
	public void testFactionCode() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("haas-bioroid", card[0].getFactionCode());
	}@Test
	public void testFactionLetter() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("h", card[0].getFactionLetter());
	}@Test
	public void testFactioncost() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/08067");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("3", card[0].getFactionCost());
	}@Test 
	public void testUniqueness() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals(false, card[0].isUniqueness());
	}
	
	}