import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class CardTest {

	@Test
	public void testCode() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("01058", card[0].getCode());
	}
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
	public void testFactionCost() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals(2, card[0].getFactionCost());
	}@Test
	public void testFlavor() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("\"Do you think they\u2026feel it?\"", card[0].getFlavor());
	}@Test
	public void testIllustrator() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("Gong Studios", card[0].getIllustrator());
	}@Test
	public void testNumber() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("58", card[0].getNumber());
	}@Test
	public void testQuantity() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("2", card[0].getQuantity());
	}@Test
	public void testSetName() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("Core Set", card[0].getSetName());
	}@Test
	public void testSetCode() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("core", card[0].getSetCode());
	}@Test 
	public void testUniqueness() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals(false, card[0].isUniqueness());
	}@Test
	public void testLimited() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals(false, card[0].isLimited());
	}@Test
	public void testCyclenumber() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01058");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		assertEquals("1", card[0].getCyclenumber());
	}
	
	}
