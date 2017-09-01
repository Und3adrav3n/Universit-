package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nomeStanza, String nomeDirezioneBloccata, String nomeAttrezzoSbloccante) {
		super(nomeStanza);
		this.direzioneBloccata = nomeDirezioneBloccata;
		this.attrezzoSbloccante = nomeAttrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		boolean sbloccata = this.hasAttrezzo(attrezzoSbloccante);

		if(this.direzioneBloccata.equals(direzione))
			if(!sbloccata)
				return this;
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		return this.toString() + "\nDirezione bloccata: " +
				direzioneBloccata + "\nAttrezzo sbloccante: " + attrezzoSbloccante;
	}
}
