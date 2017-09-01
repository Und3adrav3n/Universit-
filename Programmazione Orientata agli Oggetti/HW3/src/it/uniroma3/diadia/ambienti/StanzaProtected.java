package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class StanzaProtected {

	private String nome;				//Nome della stanza
	protected Set<Attrezzo> attrezzi;
	private Map<String,StanzaProtected> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public StanzaProtected(String nome) {	//Costruttore
		this.nome = nome;											

		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashSet<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public StanzaProtected getStanzaAdiacente(String direzione) {
		return stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;	//Restituisce il nome attuale della stanza
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();	//Restituisce il metodo ToString
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;	//Restituisce l'array contenente gli attrezzi nella stanza
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null)
			return attrezzi.add(attrezzo);
		return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();		//Inizializza uno strngbuilder per creare la stringa da restituire
		risultato.append(this.nome);						//Scrive il nome dentro la stringbuilder
		risultato.append("\nUscite:\n");						//Scrive "Uscite:" a capo
		for (StanzaProtected a : this.stanzeAdiacenti.values())				//Per ogni direzione
				risultato.append(" " + a.toString() + "\n");			//Scrive la direzione 
		risultato.append("\nAttrezzi nella stanza: ");		//Scrive "Attrezzi nella stanza:" a capo
		for (Attrezzo attrezzo : this.attrezzi) {			//Per ogni attrezzo 
			if(attrezzo != null)							//Se l'attrezzo non è nullo
				risultato.append(attrezzo.toString()+"\n");	//Scrive l'attrezzo
		}
		return risultato.toString();						//Restituisce la stringa estrapolata da stringbuilder
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;										//Dichiaro la variabile da restituire, true = l'ho trovato, false = non l'ho trovato
		trovato = false;										//Inizializzo a false
		for (Attrezzo attrezzo : this.attrezzi) {				//Per ogni attrezzo nell'array di attrezzi
			if(attrezzo != null)								//Se l'attrezzo non è nulla
				if (attrezzo.getNome().equals(nomeAttrezzo))	//Se l'attrezzo dell'array ha nome uguale a quello cercato
					trovato = true;								//L'ho trovato: trovato = true
		}
		return trovato;											//Restituisco true
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {		
		Attrezzo attrezzoCercato;							//Dichiaro la variabile da restituire
		attrezzoCercato = null;								//Inizializzo la variabile da restituire a null
		for (Attrezzo attrezzo : this.attrezzi) {			//Per ogni attrezzo nell'array di attrezzi
			if(attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))	//Se trovo l'attrezzo col nome uguale a quello cercato
					attrezzoCercato = attrezzo;					//Lo salvo nella variabile da restituire
		}
		return attrezzoCercato;								//Restituisco l'attrezzo cercato, null se non c'è
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return attrezzi.remove(attrezzo);
	}
}