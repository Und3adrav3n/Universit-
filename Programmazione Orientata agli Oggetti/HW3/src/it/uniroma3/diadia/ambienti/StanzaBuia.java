package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoPerVedere;

	public StanzaBuia(String nomeStanza, String nomeAttrezzoPerVedere) {
		super(nomeStanza);
		this.nomeAttrezzoPerVedere = nomeAttrezzoPerVedere;
	}

	@Override
	public String getDescrizione() {

		boolean vedo = this.hasAttrezzo(nomeAttrezzoPerVedere);
		
		if(vedo)
			return super.getDescrizione();
		else
			return "... qui c'è buoi pesto";
	}
}
