package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;

	private Citta citta;

	int direzione = 1;

	public Pendo(Citta citta) {
		super(progId++);
		this.citta = citta;
	}

	@Override
	public Posizione decidiDirezione(Posizione p) {

		Posizione destra, sinistra;
		destra = p.traslazioneUnitaria(1, 0);
		sinistra = p.traslazioneUnitaria(-1, 0);

		if(citta.sulBordo(destra))
			direzione=-1;
		else if(citta.sulBordo(sinistra))
			direzione=1;
		
		return p.traslazioneUnitaria(direzione, 0);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}
}
