package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	
	@Before
	public void setUp() throws Exception {
		stanzaBuia = new StanzaBuia("stanzaBuia", "lanterna");
	}

	@Test
	public void testGetDescrizione_NoOggettoCheFaLuce() {
		assertEquals("... qui c'è buoi pesto", stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_SiOggettoCheFaLuce() {
		stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 1));
		assertEquals(((Stanza)stanzaBuia).getDescrizione(), stanzaBuia.getDescrizione());
	}

}
