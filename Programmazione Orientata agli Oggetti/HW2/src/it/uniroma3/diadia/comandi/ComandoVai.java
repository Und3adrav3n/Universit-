package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;

	/**
	 * Esegue il comando di ComandoVai:
	 * Sposta il giocatore alla stanza successiva indicata
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();				//Inizializza una variabile per la stanza corrente
		Stanza prossimaStanza = null;										//Inizializza una variabile per la stanza successiva

		if (direzione == null) {											//Se il parametro direzione è nullo
			System.out.println("Direzione nulla");							//Stampa "Direzione nulla"
		}
		else {																//Se il parametro direzione non è nullo
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);	//Salvo la prossima stanza nella variabile relativa

			if(prossimaStanza == null) {									//Se la prossima stanza non c'è
				System.out.println("Muro");									//Stampa "Muro"
			}
			else {															//Se la prossima stanza esiste
				partita.setStanzaCorrente(prossimaStanza);					//Salvo come stanza corrente della partita la prossima stanza
				System.out.println(partita.getStanzaCorrente().toString());	//Stampo il nome della nuova stanza in cui mi trovo
				partita.movimentoGiocatore();								//Muovo il giocatore (perde un cfu)
				System.out.println("Ora sei nella stanza:");
				System.out.println(partita.getStanzaCorrente().getDescrizione());
			}
		}
	}

	/**
	 * Setta il parametro del comando (direzione)
	 */
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getNome() {
		return "Vai";
	}

	@Override
	public String getParametro() {
		return direzione;
	}
}
