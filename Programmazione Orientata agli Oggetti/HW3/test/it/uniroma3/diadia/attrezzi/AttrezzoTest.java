package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Nome-classe: AttrezzoTest
 * 		Classe che serve a testare alcune funzionalità dell'oggetto Attrezzo, richiesta come esercizio nella slide
 * 
 *  @author Matteo Pantaleoni
 *  @see Attrezzo
 *  @version 12.5S3
 */
public class AttrezzoTest {

	static Attrezzo attrezzo;

	@BeforeClass
	public static void setUp() {

		attrezzo = new Attrezzo("Attrezzo", 1);
	}

	@Test
	public void testCostruttore() {
		assertEquals("Attrezzo", attrezzo.getNome());
		assertEquals(1, attrezzo.getPeso());
	}
	
	@Test
	public void testToString() {
		assertEquals("Attrezzo (1kg)", attrezzo.toString());
	}
}
