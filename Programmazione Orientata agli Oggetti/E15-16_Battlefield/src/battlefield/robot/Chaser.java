package battlefield.robot;

import battlefield.Battlefield;
import battlefield.Position;

public class Chaser extends Robot {

	/* PER DOMANDA 2
	private Position posizione;
	private int longevita;
	
	public Chaser(Position p) {
		this.posizione = p;
		this.longevita = 0 ;
	}
	
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	public void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);
		if (nuova!=null) {
			Chaser clone = new Chaser(nuova);
			field.addChaser(clone);
		}
		this.incrementaLongevita();
	}
	*/
	
	public Chaser(){
		super();
	}
	
	public Chaser(Position p) {
		super(p);
	}
	
	@Override
	public Position decidiMossa(Battlefield field) {
		Walker inseguito = cercaAvversario(field);
		if (inseguito==null) 
			return null; /* nessuno da inseguire: stai fermo */
		else return inseguito.getPosizione();
	}

	private Walker cercaAvversario(Battlefield field) {
		for(Position p : field.adiacenti(this.getPosizione())) {
			Robot vicino = field.getRobot(p);
			if (vicino != null && isAvversario(vicino)) {
				return (Walker) vicino;
			}
		}
		return null;
	}

	//DOMANDA 2
	private boolean isAvversario(Object avvistato) {
		return avvistato.getClass().equals(Walker.class);
	}

}

