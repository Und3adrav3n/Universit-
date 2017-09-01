package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaDiTest;
	private Attrezzo attrezzoDiTest;

	@Before 
	public void setUp() {
		stanzaDiTest = new Stanza("StanzaDiTest");
		attrezzoDiTest = new Attrezzo("attrezzoDiTest", 1);
	}

	@Test
	public void testStanzaAdiacente_inesistente() {
		assertNull(stanzaDiTest.getStanzaAdiacente("inesistente"));
	}
	
	@Test
	public void testStanzaAdiacente_unicoStessoNome() {
		Stanza stanzaDiTest2 = new Stanza("stanzaDiTest2");
		stanzaDiTest.impostaStanzaAdiacente("nord", stanzaDiTest2);
		assertEquals(stanzaDiTest2.getNome(), stanzaDiTest.getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	public void testStanzaAdiacente_unicoStessaStanza() {
		Stanza stanzaDiTest2 = new Stanza("stanzaDiTest2");
		stanzaDiTest.impostaStanzaAdiacente("nord", stanzaDiTest2);
		assertEquals(stanzaDiTest2, stanzaDiTest.getStanzaAdiacente("nord"));
	}

	@Test
	public void testNome() {
		assertEquals("StanzaDiTest", stanzaDiTest.getNome());
	}
	
	@Test
	public void testAddAttrezzo_vuoto() {
		Attrezzo vuoto = null;
		assertFalse(stanzaDiTest.addAttrezzo(vuoto));
	}
	
	
	@Test
	public void testAddAttrezzo_aggiungoAttrezzoVero() {
		assertTrue(stanzaDiTest.addAttrezzo(attrezzoDiTest));
	}

	@Test
	public void testGetAttrezzo_inesistente() {
		assertNull(stanzaDiTest.getAttrezzo("inesistente"));
	}

	@Test
	public void testGetAttrezzo_unicoEsistenteStessoNome() {
		stanzaDiTest.addAttrezzo(attrezzoDiTest);
		assertEquals(attrezzoDiTest.getNome(), stanzaDiTest.getAttrezzo("attrezzoDiTest").getNome());
	}
	
	@Test
	public void testGetAttrezzo_unicoEsistenteStessoOggetto() {
		stanzaDiTest.addAttrezzo(attrezzoDiTest);
		assertEquals(attrezzoDiTest, stanzaDiTest.getAttrezzo("attrezzoDiTest"));
	}

	@Test
	public void testRemoveAttrezzo() {
		stanzaDiTest.addAttrezzo(attrezzoDiTest);
		assertTrue(stanzaDiTest.removeAttrezzo(attrezzoDiTest));
	}
	
	@Test
	public void testHasAttrezzo_inesistente() {
		stanzaDiTest.hasAttrezzo("inesistente");
	}
	
	@Test
	public void testHasAttrezzo_esistente() {
		Attrezzo InStanza = new Attrezzo("Ci sono", 1);
		stanzaDiTest.addAttrezzo(InStanza);
		assertTrue(stanzaDiTest.hasAttrezzo("Ci sono"));
	}
}