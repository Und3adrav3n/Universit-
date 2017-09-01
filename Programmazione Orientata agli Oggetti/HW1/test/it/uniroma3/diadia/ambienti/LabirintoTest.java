package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class LabirintoTest {

	private Labirinto labirintoTest;
	
	@Before
	public void setUp() {
		labirintoTest = new Labirinto();
	}
	
 	@Test
	public void testEntrata_giusta() {
		assertEquals("Atrio", labirintoTest.getIngresso().getNome());
	}
 	
 	@Test
 	public void testEntrata_sbagliata() {
 		assertNotEquals("Sbagliata", labirintoTest.getIngresso().getNome());
 	}
 	
 	@Test
 	public void testUscita_giusta() {
 		assertEquals("Biblioteca", labirintoTest.getUscita().getNome());
 	}
 	
 	@Test
 	public void testUscita_sbagliata() {
 		assertNotEquals("Sbagliata", labirintoTest.getUscita().getNome());
 	}
}
