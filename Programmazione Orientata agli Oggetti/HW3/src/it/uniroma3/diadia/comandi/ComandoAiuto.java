package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	/**
	 * Esegue il comando di ComandoAiuto:
	 * Stampa l'elenco dei comandi del gioco
	 */
	@Override
	public void esegui(Partita partita) {
		String[] elencoComandi = {"aiuto","fine","guarda","posa <nomeAttrezzo>","prendi <nomeAttrezzo>",
				"vai <nomeDirezione>"};	//Array di stringhe con tutti i comandi
		
		System.out.println("Elenco dei comandi:");
		for(String s : elencoComandi) 									//Per ogni elemento
			System.out.print(s + ", ");									//Stampa il comando
		System.out.println();											//Va a capo
	}

	/**
	 * Parametro non necessario per il comando aiuto
	 */
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "Aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
