package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Oggetto che si occupa di creare il labirinto
 * @author matteo
 *
 */
public class Labirinto {

	private Stanza ingresso;
	private Stanza uscita;

	/**
	 * Costruttore del labirinto, utilizza {@code init()} per inizializzare il labirinto
	 */
	public Labirinto() {
		this.init();
	}
	
	/**
	 * Inizializza il labirinto
	 */
	private void init() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		ingresso = atrio;  
		uscita  = biblioteca;
	}

	/**
	 * Restituisce la stanza ingresso del labirinto
	 * 
	 * @return stanza ingresso
	 */
	public Stanza getIngresso() {
		return this.ingresso;
	}

	/**
	 * Restituisce la stanza di uscita del labirinto
	 * 
	 * @return stanza uscita
	 */
	public Stanza getUscita() {
		return this.uscita;
	}
}
