package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	private Giocatore giocatoreTest;
	
	@Before
	public void setUp() {
		giocatoreTest = new Giocatore();
	}
	
	@Test
	public void testGetCFU_base() {
		assertEquals(20, giocatoreTest.getCFU());
	}

	@Test
	public void testSetCFU() {
		giocatoreTest.setCFU(1);
		assertEquals(1, giocatoreTest.getCFU());
	}
}
