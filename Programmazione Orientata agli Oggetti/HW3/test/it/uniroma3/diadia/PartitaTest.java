package it.uniroma3.diadia;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	private Partita partitaTest;

	@Before
	public void setUp() {
		partitaTest = new Partita();
	}

	@Test
	public void testVinta_nonAncoraVinta() {
		assertFalse(partitaTest.vinta());
	}

	@Test
	public void testVinta_vinta() {
		partitaTest.setStanzaCorrente(partitaTest.getStanzaVincente());
		assertTrue(partitaTest.vinta());
	}

	@Test
	public void testIsFinita_nonAncoraFinita() {
		assertFalse(partitaTest.isFinita());

	}

	@Test
	public void testIsFinita_finita() {
		partitaTest.setFinita();
		assertTrue(partitaTest.isFinita());
	}
}
