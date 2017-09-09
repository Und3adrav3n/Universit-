package ant.formica;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Direzione;

public class Aggressiva extends Formica {

	static private int progId=0;
	
	public Aggressiva(Ambiente ambiente) {
		super(progId, ambiente);
	}

	@Override
	public boolean decideDiCambiareDirezione() {
		return false;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {

		Direzione ciboVicino = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		
		if(ciboVicino!=null)
			return ciboVicino;
		else
			return Direzione.scegliAcasoTra(possibili);
	}

	@Override
	public Image getImmagine() {

		return IMMAGINE_FORMICA_ROSSA;
	}
}
