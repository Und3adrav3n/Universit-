package battlefield.robot;

import battlefield.Battlefield;
import battlefield.ComparatorePerXpoiY;
import battlefield.Position;

public abstract class Robot implements Comparable<Robot> {

	private Position posizione;
	private int longevita;

	public Robot(){
		this.longevita = 0;
	}

	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0;
	}

	public Position getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Position posizione) {
		this.posizione = posizione;
	}

	public int incrementaLongevita() {
		return ++this.longevita;
	}

	public int getLongevita() {
		return this.longevita;
	}

	public void passo(Battlefield field) throws InstantiationException, IllegalAccessException {
		Position nuova = this.decidiMossa(field);
		if (nuova!=null) {
			Robot clone = this.getClass().newInstance();
			clone.setPosizione(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}

	public abstract Position decidiMossa(Battlefield field);

	@Override
	public int compareTo(Robot o) {

		int comparatore = this.longevita-o.longevita;

		if(comparatore==0)
		{
			ComparatorePerXpoiY c = new ComparatorePerXpoiY();
			comparatore = c.compare(this, o);
		}

		return comparatore;
	}
}
