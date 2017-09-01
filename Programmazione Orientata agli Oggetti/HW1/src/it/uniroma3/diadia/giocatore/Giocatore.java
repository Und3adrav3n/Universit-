package it.uniroma3.diadia.giocatore;

/**
 * Quest oggetto si preoocupa di creare e gestire un giocatore della partita (i suoi cfu e la sua borsa)
 * 
 * @author matteo
 *
 */
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa zaino;
	
	/**
	 * Costruttore
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.zaino = new Borsa();
	}
	
	/**
	 * Restituisce il numero di cfu del giocatore
	 * 
	 * @return il numero di cfu 
	 * 
	 */
	public int getCFU() {
		return this.cfu;
	}
	
	/**
	 * Cambia i cfu attuali con quelli inseriti in input
	 * 
	 * @param cfu
	 */
	public void setCFU(int cfu) {
		this.cfu = cfu;
	}
	
	/**
	 * Restituisce lo zaino del giocatore
	 * 
	 * @return zaino
	 */
	public Borsa getZaino() {
		return this.zaino;
	}
	
	
}
