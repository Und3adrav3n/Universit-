package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagicaProtected;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagicaProtected stanzaMagicaBase;
	private StanzaMagicaProtected stanzaMagicaPersonalizzata;

	@Before
	public void setUp() {
		stanzaMagicaBase = new StanzaMagicaProtected("stanzaMagicaBase");
		stanzaMagicaPersonalizzata = new StanzaMagicaProtected("stanzaMagicaPersonalizzata",0);
	}
	
	@Test
	public void testGetContatoreAttrezziPosati_base() {
		assertEquals(0, stanzaMagicaBase.getContatoreAttrezziPosati());
	}
	
	@Test
	public void testGetSogliaMagica_base() {
		assertEquals(4, stanzaMagicaBase.getSogliaMagica());
	}
	
	@Test
	public void testGetSogliaMagica_personalizzata() {
		assertEquals(0,stanzaMagicaPersonalizzata.getSogliaMagica());
	}
	
	@Test
	public void testModificaAttrezzo() {
		Attrezzo attrezzo = new Attrezzo("NomeDaInvertire", 0);
		stanzaMagicaPersonalizzata.addAttrezzo(attrezzo);
		assertTrue(stanzaMagicaPersonalizzata.hasAttrezzo("eritrevnIaDemoN"));
	}
	
	@Test
	public void testModificaAttrezzo_attivazioneMagia() {
		stanzaMagicaPersonalizzata.addAttrezzo(new Attrezzo("asd", 4));
		assertTrue(stanzaMagicaPersonalizzata.hasAttrezzo("dsa"));
	}
}
