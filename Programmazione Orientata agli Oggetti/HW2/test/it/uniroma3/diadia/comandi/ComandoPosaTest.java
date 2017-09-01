package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	//TODO

	private ComandoPosa comandoPosa;
	private Partita partita;
	 
	@Before
	public void setUp() {
		comandoPosa = new ComandoPosa();
		partita = new Partita();
	}

	@Test
	public void testEsegui_nienteParametro() {
		comandoPosa.esegui(partita);
	}

	@Test
	public void testSetParametro() {
		
	}

	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParametro() {
		fail("Not yet implemented");
	}

}
