package it.uniroma3.diadia.giocatore;


import java.util.*;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPesoPoiNome;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private Map<String, Attrezzo> attrezzi;
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
		this.attrezzi = new HashMap<>();
	}

	/**
	 * Aggiunge un attrezzo alla borsa
	 * @param attrezzo
	 * @return boolean true se l'aggiunta va a buon fine, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null)
			if (this.getPeso() + attrezzo.getPeso() < this.getPesoMax()){	//Se il peso dell'oggetto da aggiungre più il peso degli oggetti già presenti eccedono il peso massimo
				this.attrezzi.put(attrezzo.getNome(), attrezzo);							//Ritorna falso e non aggiungi nulla				
				return true;
			}
		return false;												//Restituisce true dato che ha aggiunto l'attrezzo
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
		//Dichiaro la variabile da restituire
		return this.attrezzi.get(nomeAttrezzo);	//Ritorna l'attrezzo trovato, null se non è stato trovato
	}

	/**
	 * Restituisce il peso totale degli oggetti all'interno della borsa
	 * @return int peso totale degli oggetti nella borsa
	 */
	public int getPeso() {
		int peso = 0;								//Variabile da restituire
		for(Attrezzo a : this.attrezzi.values())
			peso += a.getPeso();
		return peso;
	}

	/**
	 * Verifica la mancanza di oggetti all'interno della borsa
	 * @return boolean true se la borsa è vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
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

		return attrezzi.remove(nomeAttrezzo);
	}
	
	/**
	 * Metodo che restituisce un oggetto list ordinato per peso e, in caso di peso uguale, per nome 
	 * 
	 * @return {@code ArrayList<Attrezzo>} 
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){

		ComparatorePerPesoPoiNome c = new ComparatorePerPesoPoiNome();
		List<Attrezzo> a = new ArrayList<>();
		
		a.addAll(attrezzi.values());
		
		Collections.sort(a, c);
		
		return a;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		
		ComparatorePerNome c = new ComparatorePerNome();		
		TreeSet<Attrezzo> a = new TreeSet<>(c);
		
		a.addAll(attrezzi.values());
		
		return a;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		
		ComparatorePerPesoPoiNome c = new ComparatorePerPesoPoiNome();
		TreeSet<Attrezzo> a = new TreeSet<>(c);
		
		a.addAll(this.attrezzi.values());
		
		return a;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		
		Set<Attrezzo> tmp;
		HashMap<Integer, Set<Attrezzo>> a = new HashMap<>();
		
		for(Attrezzo attrezzo : this.attrezzi.values()){
			
			tmp = a.get(attrezzo.getPeso());
			
			if(tmp == null)
				tmp = new HashSet<>();
			
			tmp.add(attrezzo);
			
			a.put(attrezzo.getPeso(), tmp);
		}
		
		return a;
	}

	/**
	 * Restituisce un elenco degli oggetti dentro la borsa che seguono il peso raggiunto da essa insieme al peso massimo
	 * @return String elenco oggetti 
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();												//Inizializza lo stringbuilder
		if (!this.isEmpty()) {																//Se la borsa non è vuota
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg):\n");	//Aggiunge il peso attuale e il massimo
			for (Attrezzo a : this.attrezzi.values())														//Per ogni attrezzo all'interno della borsa
				s.append(a.toString()+"\n");												//Aggiunge la sua descrizione allo stringbuilder
		}					
		else
			s.append("Borsa vuota");														//Se borsa vuota, aggiunge solo "borsa vuota"
		return s.toString();																//Restituisce lo stringbuilder convertito in stringa
	}
}
