package saker;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class ReadURLTester {

	@Test
	public void testaHämtaGiltigtKort() throws Exception {
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/01001");
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
		
		assertEquals("01001", card[0].getCode());
	}
	
	@Test(expected = java.io.FileNotFoundException.class)
	public void testaHämtaOgiltigtKort() throws Exception{
		String json = ImportCard.readUrl("http://netrunnerdb.com/api/card/0100a");
	}
	
	@Test(expected = java.net.MalformedURLException.class)
	public void testaTomURL() throws Exception{
		String json = ImportCard.readUrl("");
	}

}
