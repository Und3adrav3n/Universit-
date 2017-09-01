package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPesoPoiNome;

public class BorsaTest {


	private Borsa borsaPesoStandard;
	private Borsa borsaPesoPersonalizzato;
	private Attrezzo attrezzoTest1;
	private Borsa borsaVuota, singola, doppia, tripla;
	private Attrezzo primo, secondo, terzo;

	@Before
	public void setUp() {
		borsaPesoStandard = new Borsa();
		borsaPesoPersonalizzato = new Borsa(30);
		attrezzoTest1 = new Attrezzo("attrezzoTest1",15);
		borsaVuota = new Borsa(); singola = new Borsa(); doppia = new Borsa(); tripla = new Borsa();
	}

	@Test
	public void testGetPesoMax_base() {
		assertEquals(10, borsaPesoStandard.getPesoMax());
	}

	@Test
	public void testGetPesoMax_personalizzato() {
		assertEquals(30, borsaPesoPersonalizzato.getPesoMax());
	}

	@Test
	public void testAddAttrezzo_vuoto() {
		Attrezzo vuoto = null;
		assertFalse(borsaPesoPersonalizzato.addAttrezzo(vuoto));
	}

	@Test
	public void testAddAttrezzo_troppoPesante() {
		attrezzoTest1 = new Attrezzo("attrezzoTest1", 15);
		assertFalse(borsaPesoStandard.addAttrezzo(attrezzoTest1));
	}

	@Test
	public void testAddAttrezzo_nonTroppoPesante() {
		assertTrue(borsaPesoPersonalizzato.addAttrezzo(attrezzoTest1));
	}

	@Test
	public void testGetPeso_vuota() {
		assertEquals(0, borsaPesoPersonalizzato.getPeso());
	}

	@Test
	public void testGetPeso_conAttrezzo() {
		borsaPesoPersonalizzato.addAttrezzo(attrezzoTest1);
		assertEquals(15, borsaPesoPersonalizzato.getPeso());
	}

	@Test
	public void testGetPeso_con2Attrezzi() {
		doppia = new Borsa();
		doppia.addAttrezzo(new Attrezzo("1",2));
		doppia.addAttrezzo(new Attrezzo("2", 4));
		assertEquals(6, doppia.getPeso());
	}

	@Test
	public void testHasAttrezzo_attrezzoNonPresente() {
		borsaVuota = new Borsa();
		assertFalse(borsaVuota.hasAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testHasAttrezzo_attrezzoPresente() {
		borsaPesoPersonalizzato.addAttrezzo(attrezzoTest1);
		assertTrue(borsaPesoPersonalizzato.hasAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testGetAttrezzo_attrezzoNonPresente() {
		assertFalse(borsaPesoPersonalizzato.hasAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testGetAttrezzo_attrezzoPresente() {
		borsaPesoPersonalizzato.addAttrezzo(attrezzoTest1);
		assertEquals(attrezzoTest1, borsaPesoPersonalizzato.getAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testRemoveAttrezzo_presente() {
		borsaPesoPersonalizzato.addAttrezzo(attrezzoTest1);
		assertEquals(attrezzoTest1, borsaPesoPersonalizzato.removeAttrezzo("attrezzoTest1"));
	}

	@Test
	public void testRemoveAttrezzo_nonPresente() {
		assertNull(borsaPesoPersonalizzato.removeAttrezzo("Non ci sono"));
	}

	@Test 
	public void testVuota_vero() {
		assertTrue(borsaPesoPersonalizzato.isEmpty());
	}

	@Test 
	public void testVuota_falso() {
		borsaPesoPersonalizzato.addAttrezzo(attrezzoTest1);
		assertFalse(borsaPesoPersonalizzato.isEmpty());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_Vuoto(){

		List<Attrezzo> listaVuota= borsaVuota.getContenutoOrdinatoPerPeso();
		assertTrue(listaVuota.isEmpty());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_Singolo(){

		primo = new Attrezzo("primo", 1);

		ArrayList<Attrezzo> verifica = new ArrayList<>(); 
		verifica.add(primo);

		singola.addAttrezzo(primo);

		ArrayList<Attrezzo> uscita = new ArrayList<>();
		uscita.addAll(singola.getContenutoOrdinatoPerPeso());

		assertEquals(verifica, uscita);
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_Doppio(){

		primo = new Attrezzo("primo", 1);
		secondo = new Attrezzo("secondo", 2);

		ArrayList<Attrezzo> verifica = new ArrayList<>(); 
		verifica.add(primo);
		verifica.add(secondo);

		doppia.addAttrezzo(secondo);
		doppia.addAttrezzo(primo);

		ArrayList<Attrezzo> uscita = new ArrayList<>();
		uscita.addAll(doppia.getContenutoOrdinatoPerPeso());

		assertEquals(verifica, uscita);
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_Triplo(){

		primo = new Attrezzo("primo", 1);
		secondo = new Attrezzo("secondo", 2);
		terzo = new Attrezzo("terzo", 2);

		ArrayList<Attrezzo> verifica = new ArrayList<>(); 
		verifica.add(primo);
		verifica.add(secondo);
		verifica.add(terzo);

		tripla.addAttrezzo(secondo);
		tripla.addAttrezzo(terzo);
		tripla.addAttrezzo(primo);

		ArrayList<Attrezzo> uscita = new ArrayList<>();
		uscita.addAll(tripla.getContenutoOrdinatoPerPeso());

		assertEquals(verifica, uscita);
	}

	@Test
	public void testGetContenutoOrdinatoPerNome_Vuoto(){
		
		Set<Attrezzo> listaVuota= borsaVuota.getContenutoOrdinatoPerNome();
		assertTrue(listaVuota.isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_Singolo(){
		
		primo = new Attrezzo("a", 1);

		ComparatorePerNome c = new ComparatorePerNome();
		TreeSet<Attrezzo> verifica = new TreeSet<>(c);
		verifica.add(primo);

		singola.addAttrezzo(primo);

		TreeSet<Attrezzo> uscita = new TreeSet<>(c);
		uscita.addAll(singola.getContenutoOrdinatoPerNome());

		assertEquals(verifica, uscita);
	}

	@Test
	public void testGetContenutoOrdinatoPerNome_Doppio(){
		
		primo = new Attrezzo("a", 1);
		secondo = new Attrezzo("b", 1);

		ComparatorePerNome c = new ComparatorePerNome();
		TreeSet<Attrezzo> verifica = new TreeSet<>(c);
		verifica.add(primo);
		verifica.add(secondo);

		doppia.addAttrezzo(secondo);
		doppia.addAttrezzo(primo);

		TreeSet<Attrezzo> uscita = new TreeSet<>(c);
		uscita.addAll(doppia.getContenutoOrdinatoPerNome());

		assertEquals(verifica, uscita);
	}

	@Test
	public void testGetSortedSetOrdinatoPerPeso_Vuoto(){
		
		Set<Attrezzo> listaVuota= borsaVuota.getSortedSetOrdinatoPerPeso();
		assertTrue(listaVuota.isEmpty());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_Singolo(){
		
		primo = new Attrezzo("primo", 1);

		ComparatorePerPesoPoiNome c = new ComparatorePerPesoPoiNome();
		TreeSet<Attrezzo> verifica = new TreeSet<>(c);
		verifica.add(primo);

		singola.addAttrezzo(primo);

		TreeSet<Attrezzo> uscita = new TreeSet<>(c);
		uscita.addAll(singola.getSortedSetOrdinatoPerPeso());

		assertEquals(verifica, uscita);
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_Doppio(){
		
		primo = new Attrezzo("primo", 1);
		secondo = new Attrezzo("secondo", 2);

		ComparatorePerPesoPoiNome c = new ComparatorePerPesoPoiNome();
		TreeSet<Attrezzo> verifica = new TreeSet<>(c);
		verifica.add(primo);
		verifica.add(secondo);

		doppia.addAttrezzo(secondo);
		doppia.addAttrezzo(primo);

		TreeSet<Attrezzo> uscita = new TreeSet<>(c);
		uscita.addAll(doppia.getSortedSetOrdinatoPerPeso());

		assertEquals(verifica, uscita);
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_Triplo(){
		
		primo = new Attrezzo("primo", 1);
		secondo = new Attrezzo("secondo", 2);
		terzo = new Attrezzo("terzo", 2);

		ComparatorePerPesoPoiNome c = new ComparatorePerPesoPoiNome();
		TreeSet<Attrezzo> verifica = new TreeSet<>(c);
		verifica.add(primo);
		verifica.add(secondo);
		verifica.add(terzo);

		tripla.addAttrezzo(secondo);
		tripla.addAttrezzo(terzo);
		tripla.addAttrezzo(primo);

		TreeSet<Attrezzo> uscita = new TreeSet<>(c);
		uscita.addAll(tripla.getSortedSetOrdinatoPerPeso());

		assertEquals(verifica, uscita);
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_Vuoto(){
		Map<Integer, Set<Attrezzo>> listaVuota= borsaVuota.getContenutoRaggruppatoPerPeso();
		assertTrue(listaVuota.isEmpty());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso_Primo(){
		
		primo = new Attrezzo("primo", 1);

		
		HashMap<Integer, Set<Attrezzo>> verifica = new HashMap<>();
		HashSet<Attrezzo> primoInMappa = new HashSet<>();
		primoInMappa.add(primo);
		verifica.put(primo.getPeso(),primoInMappa);

		singola.addAttrezzo(primo);

		HashMap<Integer,Set<Attrezzo>> uscita = new HashMap<>();
		uscita.putAll(singola.getContenutoRaggruppatoPerPeso());

		assertEquals(verifica, uscita);
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_Doppio(){
		
		primo = new Attrezzo("primo", 1);
		secondo = new Attrezzo("secondo", 2);

		
		HashMap<Integer, Set<Attrezzo>> verifica = new HashMap<>();
		HashSet<Attrezzo> primoInMappa = new HashSet<>();
		primoInMappa.add(primo);
		HashSet<Attrezzo> secondoInMappa = new HashSet<>();
		secondoInMappa.add(secondo);
		verifica.put(primo.getPeso(),primoInMappa);
		verifica.put(secondo.getPeso(), secondoInMappa);

		doppia.addAttrezzo(secondo);
		doppia.addAttrezzo(primo);

		HashMap<Integer,Set<Attrezzo>> uscita = new HashMap<>();
		uscita.putAll(doppia.getContenutoRaggruppatoPerPeso());

		assertEquals(verifica, uscita);
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_Triplo(){
		
		primo = new Attrezzo("primo", 1);
		secondo = new Attrezzo("secondo", 2);
		terzo = new Attrezzo("terzo", 2);

		
		Map<Integer, Set<Attrezzo>> verifica = new HashMap<>();
		Set<Attrezzo> primoInMappa = new HashSet<>();
		primoInMappa.add(primo);
		Set<Attrezzo> secondoInMappa = new HashSet<>();
		secondoInMappa.add(secondo);
		secondoInMappa.add(terzo);
		verifica.put(primo.getPeso(),primoInMappa);
		verifica.put(secondo.getPeso(), secondoInMappa);


		tripla.addAttrezzo(secondo);
		tripla.addAttrezzo(terzo);
		tripla.addAttrezzo(primo);

		Map<Integer,Set<Attrezzo>> uscita = new HashMap<>();
		uscita.putAll(tripla.getContenutoRaggruppatoPerPeso());

		assertEquals(verifica, uscita);
	}
}
