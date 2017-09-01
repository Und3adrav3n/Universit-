package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	/**
	 * Esegue il comando di ComandoGuarda:
	 * Stampa le caratteristiche della partita
	 */
	@Override
	public void esegui(Partita partita) {

		System.out.println("Stanza corrente:");
		System.out.println(partita.getStanzaCorrente().toString());
		System.out.println("Obiettivo:");
		System.out.println("Devi arrivare alla stanza " + partita.getStanzaVincente().getNome());
		System.out.println("Giocatore:");
		System.out.println(partita.getGiocatore().toString());
	}

	/**
	 * Parametro non necessario per il comando guarda
	 */
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "Guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
