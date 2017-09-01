package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDiaHW1 {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "lascia"};

	private Partita partita;

	public DiaDiaHW1() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));

		scannerDiLinee.close();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome() == null) {
			System.out.println("Comando non valido");
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		}
		else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());	
		}
		else if (comandoDaEseguire.getNome().equals("lascia")) {
			this.lascia(comandoDaEseguire.getParametro());
		}
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * prende l'attrezzo dallo zaino e lo lascia nella stanza
	 * @param parametro
	 */
	private void lascia(String parametro) {

		if(parametro == null) {
			System.out.println("Indica l'attrezzo da lasciare");
		}
		else {
			Attrezzo attrezzoLasciato = partita.getGiocatore().getZaino().removeAttrezzo(parametro);	//Prendo l'attrezzo dallo zaino, rimuovendolo
			if(attrezzoLasciato == null)																//Se l'attrezzo è nullo
				System.out.println("Non hai lasciato nulla");											//Informa il giocatore che non ha lasciato nulla
			else {
				System.out.println("Hai lasciato a terra " + attrezzoLasciato.getNome());				//Informa il giocatore quale attrezzo ha lasciato
				partita.getStanzaCorrente().addAttrezzo(attrezzoLasciato);								//Aggiungo l'attrezzo nella stanza	
			}
		}
	}

	/**
	 * prende l'attrezzo e lo mette nello zaino rimuovendolo dalla stanza
	 * @param parametro
	 */
	private void prendi(String parametro) {
		if(parametro == null) {
			System.out.println("Indica l'attrezzo da prendere");
		} 
		else {
			Attrezzo attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(parametro);	//Prendo l'attrezzo dalla stanza
			if(attrezzoPreso == null)														//Se l'attrezzo è null
				System.out.println("Non hai preso nulla");									//Informa il giocatore di non aver preso nulla	
			else {
				System.out.println("Hai preso " + attrezzoPreso.getNome());					//Informa il giocatore quale oggetto ha preso
				partita.getGiocatore().getZaino().addAttrezzo(attrezzoPreso);				//Metto l'attrezzo preso nello zaino
				partita.getStanzaCorrente().removeAttrezzo(attrezzoPreso);					//Rimuovo l'attrezzo dalla stanza
			}
		}
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 	//Per ogni comando nell'array di stringhe elencoComandi
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {

		if (direzione == null) {
			System.out.println("Dopo vai scrivi una di queste direzioni:");
			for(String s: this.partita.getStanzaCorrente().getDirezioni())
				System.out.print(s + " ");
			System.out.println();
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null) {
				System.out.println("Stanza inesistente nella direzione indicata");
			}
			else {
				this.partita.setStanzaCorrente(prossimaStanza);
				int cfu = this.partita.getGiocatore().getCFU();
				this.partita.getGiocatore().setCFU(cfu--);
			}
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	/**
	 * Main
	 * @param argc
	 */
	public static void main(String[] argc) {
		DiaDiaHW1 gioco = new DiaDiaHW1();
		gioco.gioca();
	}
}