package saker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporationTest {

	@Test
	public void getClickTest() {
		assertEquals(3,new Corporation().getClicks());
	}
	
	public void setClickTest() {
		Corporation corp = new Corporation();
		corp.setClicks(2);
		assertEquals(2,corp.getClicks());
	}

}
