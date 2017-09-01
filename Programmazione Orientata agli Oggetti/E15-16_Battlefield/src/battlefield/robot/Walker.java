package battlefield.robot;

import battlefield.Battlefield;
import battlefield.Position;

public class Walker extends Robot {

	/* PER DOMANDA 2
	private Position posizione;
	private int longevita;
	
	public Walker(Position p) {
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
			Walker clone = new Walker(nuova);
			field.addWalker(clone);
		}
		this.incrementaLongevita();
	}
	*/
	
	public Walker(){
		super();
	}

	public Walker(Position p) {
		super(p);
	}
	
	@Override
	public Position decidiMossa(Battlefield field) {
		Position corrente = this.getPosizione();
		Position libera = field.posizioneLiberaVicino(corrente);
		return libera; // verso una posizione libera
					   // tutto occupato: fermo
	}
}

