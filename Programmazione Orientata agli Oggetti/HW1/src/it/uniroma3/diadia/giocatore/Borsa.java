package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	/**
	 * Costruttore, il peso massimo non indicato è settato al valore di default
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	/**
	 * Costruttore, pesoMax è il peso massimo trasportabile dalla borsa
	 * @param pesoMax
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;				
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	/**
	 * Aggiunge un attrezzo alla borsa
	 * @param attrezzo
	 * @return boolean true se l'aggiunta va a buon fine, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)											//Se l'attrezzo non esiste
			return false;												//Ritorna falso e non aggiungi nulla				
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())	//Se il peso dell'oggetto da aggiungre più il peso degli oggetti già presenti eccedono il peso massimo
			return false;												//Ritorna falso e non aggiungi nulla				
		if (this.numeroAttrezzi==10)									//Se la borsa è piena
			return false;												//Restituisce falso e non aggiunge nulla
		this.attrezzi[this.numeroAttrezzi] = attrezzo;					//Aggiunge l'attrezzo alla prima posizione libera
		this.numeroAttrezzi++;											//Incrementa il numero degli attrezzi di 1			
		return true;													//Restituisce true dato che ha aggiunto l'attrezzo
	}

	/**
	 * Serve ad ottenere il peso massimo
	 * @return int peso massimo trasportabile
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * Restituisce l'attrezzo corrispondente al nome dato, se presente
	 * @param nomeAttrezzo
	 * @return Attrezzo che ha il nome cercato, null altrimenti
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;											//Dichiaro la variabile da restituire
		for (int i= 0; i<this.numeroAttrezzi; i++)					//Per ogni attrezzo dell'array di attrezzi
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {	//Se l'attrezzo attuale dell'array è quello che cerco
				a = attrezzi[i];									//Salva l'attrezzo trovato nelal variabile da restituire
				break;												//Interrompi il ciclo
			}
		return a;													//Ritorna l'attrezzo trovato, null se non è stato trovato
	}

	/**
	 * Restituisce il peso totale degli oggetti all'interno della borsa
	 * @return int peso totale degli oggetti nella borsa
	 */
	public int getPeso() {
		int peso = 0;								//Variabile da restituire
		for (int i= 0; i<this.numeroAttrezzi; i++)	//Per ogni attrezzo della borsa
			peso += this.attrezzi[i].getPeso();		//Aggiungi il suo peso al peso totale
		return peso;								//Restituisce il peso totale
	}

	/**
	 * Verifica la mancanza di oggetti all'interno della borsa
	 * @return boolean true se la borsa è vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	/**
	 * Verifica la presenza nella borsa di un attrezzo
	 * @param nomeAttrezzo
	 * @return boolean true se la borsa contiene l'attrezzo richiesto, false altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * Restituisce l'attrezzo richiesto in input e lo elimina dalla borsa, se presente
	 * 
	 * @param nomeAttrezzo
	 * @return attrezzo estratto, altrimenti null
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null; 	//Attrezzo da restituire
		int i;             	//Iteratore
		boolean preso;     	//false = oggetto non trovato, true = oggetto trovato e preso

		for(i = 0, preso = false; i < numeroAttrezzi; i++) {	//Per ogni attrezzo nell'array attrezzi
			if(attrezzi[i].getNome().equals(nomeAttrezzo)) {	//Se trovo l'attrezzo che sto cercando
				a = attrezzi[i];								//Salvo l'attrezzo in a
				preso = true;									//Salvo il fatto di averlo trovato e preso
			}
			if(preso)											//Se ho preso l'attrezzo cercato
				attrezzi[i] = attrezzi[i+1];  					//Scalo i rimanenti attrezzi indietro di uno
		}
		numeroAttrezzi--;										//Salvo il fatto di avere un attrezzo in meno
		return a;												//Restituisco l'attrezzo
	}

	/**
	 * Restituisce un elenco degli oggetti dentro la borsa che seguono il peso raggiunto da essa insieme al peso massimo
	 * @return String elenco oggetti 
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();												//Inizializza lo stringbuilder
		if (!this.isEmpty()) {																//Se la borsa non è vuota
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");	//Aggiunge il peso attuale e il massimo
			for (int i= 0; i<this.numeroAttrezzi; i++)										//Per ogni attrezzo all'interno della borsa
				s.append(attrezzi[i].toString()+" ");										//Aggiunge la sua descrizione allo stringbuilder
		}					
		else
			s.append("Borsa vuota");														//Se borsa vuota, aggiunge solo "borsa vuota"
		return s.toString();																//Restituisce lo stringbuilder convertito in stringa
	}
}
