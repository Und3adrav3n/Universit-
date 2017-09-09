package ant.simulatore;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	

	final private Coordinate origine = new Coordinate(0, 0);

	private Esploratrice formica ;
	private Inseguitrice altraFormica ;

	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
	}


	private Cibo creaCiboRaccoltoDaEsploratore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaEsploratrice());	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaInseguitrice());	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormica() {

		Set<Cibo> raccolto = new HashSet<>();
		raccolto.add(this.creaCiboRaccoltoDaEsploratore());
		assertEquals(1, this.stats.raccoltoPerFormica(raccolto).size());;
	}

	@Test
	public void testRaccoltoPerTipoDiFormica() {

		Set<Cibo> raccolto = new HashSet<>();
		raccolto.add(this.creaCiboRaccoltoDaEsploratore());
		raccolto.add(this.creaCiboRaccoltoDaEsploratore());
		raccolto.add(this.creaCiboRaccoltoDaInseguitore());
		assertEquals(2, this.stats.raccoltoPerTipoDiFormica(raccolto).size());;
		assertEquals(2, this.stats.raccoltoPerTipoDiFormica(raccolto).get(Esploratrice.class).size());
		assertEquals(1, this.stats.raccoltoPerTipoDiFormica(raccolto).get(Inseguitrice.class).size());
	}

}
