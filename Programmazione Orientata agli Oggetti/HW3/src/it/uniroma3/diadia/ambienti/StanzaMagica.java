package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	//Soglia dopo la quale si attiva la magia
	final private static int SOGLIA_MAGICA_DEFAULT = 4;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	/**
	 * Costruttore con nome e soglia magica in input
	 * 
	 * @param nome
	 * @param sogliaMagica
	 */
	public StanzaMagica(String nome, int sogliaMagica) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = sogliaMagica;
	}

	/**
	 * Costruttore2 con nome in input e soglia preimpostata
	 * @param nome
	 */
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	//Getters
	public int getContatoreAttrezziPosati() {
		return contatoreAttrezziPosati;
	}
	public int getSogliaMagica() {
		return sogliaMagica;
	}

	/**
	 * Attiva la magia
	 * 
	 * @param attrezzo
	 * @return
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {

		StringBuilder nomeInvertito;
		int pesodoppio;

		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();

		pesodoppio = attrezzo.getPeso()*2;

		attrezzo = new Attrezzo(nomeInvertito.toString(), pesodoppio);

		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++;
		
		if(this.contatoreAttrezziPosati > this.sogliaMagica)
			attrezzo = modificaAttrezzo(attrezzo);
		
		return super.addAttrezzo(attrezzo);
	}





}
