package it.uniroma3.diadia.ambienti;

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

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;				//Nome della stanza
	private Attrezzo[] attrezzi;		//Array di Attrezzi degli attrezzi contenuti
	private int numeroAttrezzi;			//Intero di attrezzi nella stanza
	private Stanza[] stanzeAdiacenti;	//Array delle stanze adiacenti
	private int numeroStanzeAdiacenti;	//Intero di stanze adiacenti
	private String[] direzioni;			//Array di Stringhe delle direzioni indicate

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {	//Costruttore
		this.nome = nome;											
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;						//Registra se aggiorno una stanza già esistente 
		for(int i=0; i<this.direzioni.length; i++)		//Scorro le direzioni già occupate
			if (direzione.equals(this.direzioni[i])) {	//Se trovo una direzione già occupata
				this.stanzeAdiacenti[i] = stanza;		//Aggiorno la stanza presente con la nuova
				aggiornato = true;						//Ho aggiornato la stanza e finito
			}
		if (!aggiornato)													//Se non ho aggiornato nessuna stanza
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {	//Se ho meno stanze delle stanze adiacenti massime
				this.direzioni[numeroStanzeAdiacenti] = direzione;			//Aggiungo una direzione all'array di direzioni
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;		//Aggiungo la stanza all'array delle stanze adiacenti
				this.numeroStanzeAdiacenti++;								//Incremento il numero delle stanze adiacenti di 1
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;							//Dichiaro la stanza da ritornare
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)	//Per ogni stanza adiacente
			if (this.direzioni[i].equals(direzione))	//Se la direzione cercata è uguale ad una presente
				stanza = this.stanzeAdiacenti[i];		//Salvo la stanza trovata nella variabile di ritorno
		return stanza;									//Ritorno la stanza nella direzione cercata
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
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;	//Restituisce l'array contenente gli attrezzi nella stanza
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {	//Se non ho raggiunto il massimo numero di attrezzi
			this.attrezzi[numeroAttrezzi] = attrezzo;			//Aggiungo all'array di attrezzi l'attrezzo da aggiungere
			this.numeroAttrezzi++;								//Invremento il contatore di attrezzi presenti
			return true;										//Restituisco true dato che ho inserito l'oggetto
		}
		else {													//Ho raggiunto il massimo numero di attrezzi da poter inserire
			return false;										//Restituisco false dato che non ho inserito l'attrezzo richiesto
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();		//Inizializza uno strngbuilder per creare la stringa da restituire
		risultato.append(this.nome);						//Scrive il nome dentro la stringbuilder
		risultato.append("\nUscite: ");						//Scrive "Uscite:" a capo
		for (String direzione : this.direzioni)				//Per ogni direzione
			if (direzione!=null)							//Se la direzione attuale non è nulla
				risultato.append(" " + direzione);			//Scrive la direzione 
		risultato.append("\nAttrezzi nella stanza: ");		//Scrive "Attrezzi nella stanza:" a capo
		for (Attrezzo attrezzo : this.attrezzi) {			//Per ogni attrezzo 
			if(attrezzo != null)							//Se l'attrezzo non è nullo
				risultato.append(attrezzo.toString()+" ");	//Scrive l'attrezzo
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

		int i;             	//Iteratore
		boolean preso;     	//false = oggetto non trovato, true = oggetto trovato e preso

		for(i = 0, preso = false; i < numeroAttrezzi; i++) {		//Per ogni attrezzo nell'array attrezzi
			if(attrezzi[i].getNome().equals(attrezzo.getNome()))	//Se trovo l'attrezzo che sto cercando
				preso = true;										//Salvo il fatto di averlo trovato e preso
			if(preso)												//Se ho preso l'attrezzo cercato
				attrezzi[i] = attrezzi[i+1];  						//Scalo i rimanenti attrezzi indietro di uno
		}
		numeroAttrezzi--;											//Salvo il fatto di avere un attrezzo in meno
		return preso;												//True se l'ho tolto, false altrimenti
	}

	/**
	 * Salva ogni direzione con una stanza dentro un array da restituire
	 * @return array di stringhe contenente le direzioni
	 */
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];	//Inizializzo l'array da restituire
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)					//Per ogni int da 0 minore del numero di stanze adiacenti
			direzioni[i] = this.direzioni[i];							//salvo la direzione relativa nell'array da restituire
		return direzioni;												//Restituisco l'array con le direzioni
	}
	
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

}