package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public abstract class Politica {

	final private Random rnd;
	
	private int id;
	
	public Politica(int id) {
		this.id = id;
		this.rnd = new Random();
	}
	
	public int getId() {
		return this.id;
	}
	
	public abstract Posizione decidiDirezione(Posizione p);
	
	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	protected int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	
	public abstract Image getImmagine();
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
