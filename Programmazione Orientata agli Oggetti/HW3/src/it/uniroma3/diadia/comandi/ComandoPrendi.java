package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;

	/**
	 * Esegue il comando di ComandoPrendi:
	 * Prende l'attrezzo dalla stanza e lo mette nello zaino del giocatore
	 */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);	//Prendo l'attrezzo dalla stanza
		if(attrezzoPreso == null)
			System.out.println("Non hai preso nulla");
		else {
			System.out.println("Hai preso " + attrezzoPreso.getNome());
			partita.getGiocatore().getZaino().addAttrezzo(attrezzoPreso);					//Metto l'attrezzo preso nello zaino
			partita.getStanzaCorrente().removeAttrezzo(attrezzoPreso);						//Rimuovo l'attrezzo dalla stanza
		}
	}						

	/**
	 * Setta il parametro del comando (nomeAttrezzo)
	 */
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "Prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
