package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Labirinto università;
	private Giocatore studente;
	private boolean finita;
	
	/**
	 * Costruttore
	 */
	public Partita(){
		studente = new Giocatore();
		università = new Labirinto();
		this.stanzaCorrente = università.getIngresso();
		this.stanzaVincente = università.getUscita();
		this.finita = false;
	}

	/**
	 * Restituisce la stanza vincente della partita
	 * @return Stanza vincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	/**
	 * Permette di importare la stanza corrente della partita
	 * @param stanzaCorrente
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	/**
	 * Restituisce la stanza corrente della partita
	 * @return Stanza corrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (studente.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * Restituisce il giocatore della partita
	 * @return Giocatore
	 */
	public Giocatore getGiocatore() {
		return this.studente;
	}
}