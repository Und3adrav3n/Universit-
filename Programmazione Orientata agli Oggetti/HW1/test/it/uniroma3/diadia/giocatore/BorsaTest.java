package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {


	private Borsa borsaTest1;
	private Borsa borsaTest2;
	private Attrezzo attrezzoTest1;

	@Before
	public void setUp() {
		borsaTest1 = new Borsa();
		borsaTest2 = new Borsa(30);
		attrezzoTest1 = new Attrezzo("attrezzoTest1", 15);
	}

	@Test
	public void testGetPesoMax_base() {
		assertEquals(10, borsaTest1.getPesoMax());
	}

	@Test
	public void testGetPesoMax_personalizzato() {
		assertEquals(30, borsaTest2.getPesoMax());
	}

	@Test
	public void testAddAttrezzo_vuoto() {
		Attrezzo vuoto = null;
		assertFalse(borsaTest2.addAttrezzo(vuoto));
	}
	
	@Test
	public void testAddAttrezzo_troppoPesante() {
		assertFalse(borsaTest1.addAttrezzo(attrezzoTest1));
	}

	@Test
	public void testAddAttrezzo_nonTroppoPesante() {
		assertTrue(borsaTest2.addAttrezzo(attrezzoTest1));
	}

	@Test
	public void testGetPeso_vuota() {
		assertEquals(0, borsaTest2.getPeso());
	}

	@Test
	public void testGetPeso_conAttrezzo() {
		borsaTest2.addAttrezzo(attrezzoTest1);
		assertEquals(15, borsaTest2.getPeso());
	}

	@Test
	public void testHasAttrezzo_attrezzoNonPresente() {
		assertFalse(borsaTest2.hasAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testHasAttrezzo_attrezzoPresente() {
		borsaTest2.addAttrezzo(attrezzoTest1);
		assertTrue(borsaTest2.hasAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testGetAttrezzo_attrezzoNonPresente() {
		assertFalse(borsaTest2.hasAttrezzo("attrezzoTest1"));
	}
	
	@Test
	public void testGetAttrezzo_attrezzoPresente() {
		borsaTest2.addAttrezzo(attrezzoTest1);
		assertEquals(attrezzoTest1, borsaTest2.getAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testRemoveAttrezzo_presente() {
		borsaTest2.addAttrezzo(attrezzoTest1);
		assertEquals(attrezzoTest1, borsaTest2.removeAttrezzo("attrezzoTest1"));
	}
	
	@Test
	public void testRemoveAttrezzo_nonPresente() {
		assertNull(borsaTest2.removeAttrezzo("Non ci sono"));
	}
	
	@Test 
	public void testVuota_vero() {
		assertTrue(borsaTest2.isEmpty());
	}
	
	@Test 
	public void testVuota_falso() {
		borsaTest2.addAttrezzo(attrezzoTest1);
		assertFalse(borsaTest2.isEmpty());
	}

}
