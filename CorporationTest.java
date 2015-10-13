package saker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporationTest {

	@Test
	public void Clicktest() {
		assertEquals(2,new Corporation(2).getClicks());
	}

}
