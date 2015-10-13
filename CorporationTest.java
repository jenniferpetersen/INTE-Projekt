package saker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporationTest {

	@Test
	public void Clicktest() {
		assertEquals(3,new Corporation(3).getClicks());
	}

}
