package ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	

	final static private Posizione ORIGINE = new Posizione(0, 0);

	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}


	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}

	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */

	@Test
	public void testRaccoltoPerMezzo() {

		Mezzo m1, m2;
		m1 = new Mezzo(simulatore, new Brown());
		m2 = new Mezzo(simulatore, new Brown());

		Rifiuto r1, r2;
		r1 = new Vetro(ORIGINE);
		r2 = new Vetro(ORIGINE);

		r1.setRaccoltoDa(m1);
		r2.setRaccoltoDa(m2);

		Set<Rifiuto> smaltiti = new HashSet<>();
		smaltiti.add(r1);
		smaltiti.add(r2);

		Map<Mezzo, Integer> rPm = stats.raccoltoPerMezzo(smaltiti);
		assertEquals(2,rPm.size());

	}


	@Test
	public void testRaccoltoPerPolitica() {

		Rifiuto r = this.creaVetroRaccoltoDaBrowniano();

		Set<Rifiuto> smaltiti = new HashSet<>();
		smaltiti.add(r);

		Map<Class<?>, Integer> rPp = stats.raccoltoPerPolitica(smaltiti);
		assertEquals(1, rPp.size());
	}

	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */
	@Test
	public void testordinaPolitichePerRaccolta_vuota() {
		Map<Class<?>, Integer> politica2quantita = new HashMap<>();
		assertTrue(stats.ordinaPolitichePerRaccolta(politica2quantita).isEmpty());
	}
	
	@Test
	public void testordinaPolitichePerRaccolta_nonVuota() {
		Map<Class<?>, Integer> politica2quantita = new HashMap<>();
		politica2quantita.put(Chase.class, 1);
		assertFalse(stats.ordinaPolitichePerRaccolta(politica2quantita).isEmpty());
	}
	
	@Test
	public void testordinaPolitichePerRaccolta_duePolitiche() {
		Map<Class<?>, Integer> politica2quantita = new HashMap<>();
		politica2quantita.put(Chase.class, 2);
		politica2quantita.put(Brown.class, 4);
		assertEquals(Brown.class, stats.ordinaPolitichePerRaccolta(politica2quantita).get(0));
		assertEquals(Chase.class, stats.ordinaPolitichePerRaccolta(politica2quantita).get(1));
	}

}
