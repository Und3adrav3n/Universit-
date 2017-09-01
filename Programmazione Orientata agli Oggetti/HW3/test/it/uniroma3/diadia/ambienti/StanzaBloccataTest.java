package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	
	@Before
	public void setUp() throws Exception {
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", "nord", "chiave");
	}
	
	@Test
	public void testGetStanzaAdiacente_EsistenteBloccataNoOggettoSbloccante() {
		assertSame(stanzaBloccata,stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_EsistenteBloccataSiOggettoSbloccante() {
		Stanza stanzaAdiacente = new Stanza("stanzaAdiacente");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
		stanzaBloccata.addAttrezzo(new Attrezzo("chiave", 1));
		assertSame(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_EsistenteSbloccata() {
		Stanza stanzaAdiacente = new Stanza("stanzaAdiacente");
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertSame(stanzaAdiacente,stanzaBloccata.getStanzaAdiacente("sud"));
	}
}
