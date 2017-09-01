package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

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

public class Stanza implements Comparable<Stanza>{

	private String nome;				//Nome della stanza
	private Map<String,Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {	//Costruttore
		this.nome = nome;											
		this.attrezzi = new HashMap<>();
		this.stanzeAdiacenti = new HashMap<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);								//Ritorno la stanza nella direzione cercata
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
	public Map<String, Attrezzo> getAttrezzi() {

		return attrezzi;	//Restituisce l'array contenente gli attrezzi nella stanza
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null){
			attrezzi.put(attrezzo.getNome(),attrezzo);
			return true;
		}
		else 
			return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {

		StringBuilder risultato = new StringBuilder();					//Inizializza uno strngbuilder per creare la stringa da restituire

		risultato.append(this.nome);									//Scrive il nome dentro la stringbuilder

		risultato.append("\nUscite:\n");								//Scrive "Uscite:" a capo
		for (Stanza a : this.stanzeAdiacenti.values())					//Per ogni direzione
			risultato.append(" " + a.toString() + "\n");				//Scrive la direzione 

		risultato.append("\nAttrezzi nella stanza:\n");					//Scrive "Attrezzi nella stanza:" a capo
		for (Attrezzo attrezzo : this.attrezzi.values())				//Per ogni attrezzo 
			risultato.append(attrezzo.toString() + "\n");				//Scrive l'attrezzo																

		return risultato.toString();									//Restituisce la stringa estrapolata da stringbuilder
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {

		return attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {		

		return attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {

		return attrezzi.remove(attrezzo.getNome(), attrezzo);
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	@Override
	public int compareTo(Stanza o) {
		return this.nome.compareTo(o.getNome());
	}
}