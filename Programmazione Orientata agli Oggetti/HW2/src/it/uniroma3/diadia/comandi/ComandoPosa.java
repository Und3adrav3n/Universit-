package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;

	/**
	 * Esegue il comando di ComandoPosa:
	 * Posa l'attrezzo indicato dalla borsa alla stanza
	 */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoLasciato = partita.getGiocatore().getZaino().removeAttrezzo(nomeAttrezzo);	//Prendo l'attrezzo dallo zaino, rimuovendolo
		if(attrezzoLasciato == null)
			System.out.println("Non hai lasciato nulla");
		else {
			System.out.println("Hai lasciato a terra " + attrezzoLasciato.getNome());
			partita.getStanzaCorrente().addAttrezzo(attrezzoLasciato);								//Aggiungo l'attrezzo nella stanza	
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
		return "Posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
