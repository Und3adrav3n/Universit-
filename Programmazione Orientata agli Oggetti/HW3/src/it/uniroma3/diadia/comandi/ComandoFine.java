package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	/**
	 * Esegue il comando di ComandoFine:
	 * Stampa i ringraziamenti e setta la partita come finita
	 */
	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");	//Ringrazia il giocatore
		partita.setFinita();							//Setta il parametro fine a true indicando la fine della partita
	}

	/**
	 * Parametro non necessario per il comando fine
	 */
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "Fine";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
