package battlefield;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import battlefield.robot.Chaser;
import battlefield.robot.Robot;
import battlefield.robot.Walker;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;

	/* PER DOMANDA 2
	private Map<Position, Walker> posizione2walker;
	private Map<Position, Chaser> posizione2chaser;
	 */

	private Map<Position,Robot> posizione2robot;

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		this.posizione2robot = new HashMap<>();
		this.random = new Random();
	}

	//DOMANDA 1
	public void addRobot(Robot r) 
	{
		this.posizione2robot.put(r.getPosizione(), r);
	}

	/* PER DOMANDA 2
	//DOMANDA 1
	public void addChaser(Chaser c) 
	{
		this.posizione2chaser.put(c.getPosizione(), c);
	}
	 */
	public Robot getRobot(Position p) {
		return posizione2robot.get(p);
	}

	/* PER DOMANDA 2
	public Chaser getChaser(Position p) {
		return posizione2chaser.get(p);
	}
	 */

	public Collection<Robot> getAllRobots() {
		return this.posizione2robot.values();
	}

	/* PER DOMANDA 2
	public Collection<Chaser> getAllChasers() {
		return this.posizione2chaser.values();
	}
	 */

	//DOMANDA 3
	public Map<Class<?>, Set<?>> raggruppaRobotPerTipo() {

		Map<Class<?>, Set<?>> raggruppatiPerTipo = new HashMap<>();

		for(Robot r : posizione2robot.values())
		{
			Class<? extends Robot> key = r.getClass();

			@SuppressWarnings("unchecked")
			Set<Robot> value = ((Set<Robot>) raggruppatiPerTipo.get(key));

			if(value == null)
				value = new HashSet<>();

			value.add(r);

			raggruppatiPerTipo.put(key, value);
		}
		return raggruppatiPerTipo;
	}

	//DOMANDA 4
	public List<?> getRobotOrdinatiPerPosizione() {

		List<Robot> robotOrdinati = new ArrayList<>();
		
		robotOrdinati.addAll(posizione2robot.values());
		
		ComparatorePerXpoiY c = new ComparatorePerXpoiY();
		Collections.sort(robotOrdinati, c);
		
		return robotOrdinati;
	}

	//DOMANDA 6
	public SortedSet<?> getRobotOrdinatiPerLongevita() {
		
		SortedSet<Robot> robotOrdinati = new TreeSet<>();
		
		robotOrdinati.addAll(posizione2robot.values());
		
		return robotOrdinati;
	}

	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti

		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;

	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return this.getRobot(posizione)==null;
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Chaser chaser = new Chaser(posizione);
				this.addRobot(chaser);
				break;
				case 1: Walker walker = new Walker(posizione);
				this.addRobot(walker);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}
}
