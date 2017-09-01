package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	/**
	 * Esegue il comando di ComandoNonValido:
	 * Stampa l'inesistenza del comando richiesta
	 */
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non valido");	
	}

	/**
	 * Parametro non necessario per il comando non valido
	 */
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "NonValido";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
